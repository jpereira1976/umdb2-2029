package edu.um.db2.demospringboot.primer_parcial;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="accounts")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    private double balance;
    private Date creationDate;
}
