package edu.um.db2.demospringboot.eventstore;

public interface EventStore {
    void emit(Event event);
    void addListener(EventStoreListener listener, Class eventClass);
}
