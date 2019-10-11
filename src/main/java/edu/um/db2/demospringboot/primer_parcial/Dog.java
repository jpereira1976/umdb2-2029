package edu.um.db2.demospringboot.primer_parcial;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class Dog extends Animal {
    private String color;
}
