package edu.um.db2.demospringboot.primer_parcial;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class Animal {
    private String name;
}
