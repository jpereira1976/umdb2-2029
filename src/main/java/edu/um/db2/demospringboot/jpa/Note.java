package edu.um.db2.demospringboot.jpa;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="notes")
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "title2", nullable = false, length = 40)
    private String title;

    @NotBlank
    @Column(nullable = false, length = 80)
    private String content;

}
