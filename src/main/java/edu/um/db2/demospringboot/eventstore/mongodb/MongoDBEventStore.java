package edu.um.db2.demospringboot.eventstore.mongodb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;
import edu.um.db2.demospringboot.eventstore.Event;
import edu.um.db2.demospringboot.eventstore.EventStore;
import edu.um.db2.demospringboot.eventstore.EventStoreListener;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MongoDBEventStore implements EventStore {
    private MongoDatabase database;
    private Map<String, List<EventStoreListener>> listenersMap;

    public MongoDBEventStore(MongoDatabase database) {
        this.database = database;
        listenersMap = new HashMap<>();
    }

    @Override
    public void emit(Event event) {
        try {
            database.getCollection("events")
                    .insertOne(new Document("body",
                            Document.parse(new ObjectMapper().writeValueAsString(event)))
                    .append("in-progress", false).append("done", false)
                    .append("type", event.getClass().getName()));
        } catch (JsonProcessingException e) {
            throw new EventStoreException(e);
        }
    }

    @Override
    public void addListener(EventStoreListener listener, Class eventClass) {
        String eventClassName = eventClass.getName();
        List<EventStoreListener> listeners = listenersMap.get(eventClassName);
        if (listeners == null) {
            listeners = new ArrayList<>();
            listenersMap.put(eventClassName, listeners);
        }
        listeners.add(listener);
    }

    public void init() {
        Executor executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            while(true) {
                try {
                    Document eventDocument = database.getCollection("events")
                            .findOneAndUpdate(
                                    new Document("done", false).append("in-progress", false),
                                    new Document("$set", new Document("in-progress", true))
                            );

                    if (eventDocument != null) {

                        Event event = (Event) new ObjectMapper().readValue(((Document)eventDocument.get("body")).toJson(),
                                Class.forName(eventDocument.getString("type")));

                        List<EventStoreListener> listeners = listenersMap.get(eventDocument.getString("type"));

                        executor.execute(() -> {
                            if (listeners != null)
                                listeners.forEach(listener -> listener.process(event));

                            database.getCollection("events").updateOne(
                                    new Document("_id", eventDocument.getObjectId("_id")),
                                    new Document("$set", new Document("in-progress", false)
                                            .append("done", true))
                            );
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
