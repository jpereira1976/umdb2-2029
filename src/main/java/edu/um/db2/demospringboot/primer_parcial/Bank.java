package edu.um.db2.demospringboot.primer_parcial;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="banks")
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="bank_accounts",
            joinColumns = @JoinColumn( name="bank_id"),
            inverseJoinColumns = @JoinColumn( name="account_id"))
    private List<Account> accounts;
}
