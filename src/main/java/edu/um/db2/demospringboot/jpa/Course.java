package edu.um.db2.demospringboot.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_ANNOTATION")
@Data
public class Course {
    @Id
    CoursePK id;
    int totalStudents;
    int registeredStudents;
}

