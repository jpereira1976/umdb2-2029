package edu.um.db2.demospringboot.jpa;


import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SHOWROOM_LIST_ANN")
@Data
public class Showroom {
    @Id
    @Column(name="SHOWROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    @JoinColumn(name="SHOWROOM_ID")
    @JoinTable(name="SHOWROOM_CAR")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Car> cars;

    private String manager;

    private String location;
}
