package edu.um.db2.demospringboot.eventstore.mongodb.test;

import edu.um.db2.demospringboot.eventstore.Event;
import edu.um.db2.demospringboot.eventstore.EventStoreListener;

public class SomethingHappendsEventListener implements EventStoreListener {

    @Override
    public void process(Event event) {
        System.out.println(((SomethingHappendsEvent)event).getText());
    }
}
