package edu.um.db2.demospringboot.eventstore.mongodb;

import com.fasterxml.jackson.core.JsonProcessingException;

public class EventStoreException extends RuntimeException {
    public EventStoreException(JsonProcessingException e) {
        super(e);
    }
}
