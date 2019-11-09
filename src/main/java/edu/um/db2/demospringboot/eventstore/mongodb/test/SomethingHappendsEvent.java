package edu.um.db2.demospringboot.eventstore.mongodb.test;

import edu.um.db2.demospringboot.eventstore.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SomethingHappendsEvent implements Event {
    private String text;
}
