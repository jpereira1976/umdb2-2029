package edu.um.db2.demospringboot.eventstore;

public interface EventStoreListener {
    void process(Event event);
}
