package edu.um.db2.demospringboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    CourseRepository repository;

    @PostMapping("/course")
    public void save(@RequestBody Course course) {
        repository.save(course);
    }

}
