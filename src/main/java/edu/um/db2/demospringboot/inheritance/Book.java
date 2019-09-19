package edu.um.db2.demospringboot.inheritance;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("1")
public class Book extends MyProduct {
    private String author;
}
