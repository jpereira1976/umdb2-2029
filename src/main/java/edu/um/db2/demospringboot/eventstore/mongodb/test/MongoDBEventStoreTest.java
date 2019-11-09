package edu.um.db2.demospringboot.eventstore.mongodb.test;

import com.mongodb.MongoClient;
import edu.um.db2.demospringboot.eventstore.mongodb.MongoDBEventStore;

import java.util.concurrent.ExecutionException;

public class MongoDBEventStoreTest {

    public static void main(String[] args) throws Exception {
        MongoDBEventStore eventStore = new MongoDBEventStore(
                new MongoClient().getDatabase("test")
        );
        eventStore.addListener(new SomethingHappendsEventListener(),
                SomethingHappendsEvent.class);
        eventStore.init();

        eventStore.emit(new SomethingHappendsEvent("Hola Mundo"));

        Thread.sleep(10000);

        System.exit(0);
    }
}
