package edu.um.db2.demospringboot.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="CAR_LIST_ANN")
@Data
public class Car {
    @Id
    @Column(name="CAR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String color;
}
