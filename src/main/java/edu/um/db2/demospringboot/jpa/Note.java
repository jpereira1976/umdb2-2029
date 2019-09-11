package edu.um.db2.demospringboot.jpa;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="notes")
@Data
@Builder
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
