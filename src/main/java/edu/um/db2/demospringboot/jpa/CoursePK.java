package edu.um.db2.demospringboot.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Data
public class CoursePK implements Serializable {
    String tutor;
    String title;
}
