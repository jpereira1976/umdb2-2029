package edu.um.db2.demospringboot.xstream;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private PhoneNumber phone;
    private PhoneNumber fax;
}
