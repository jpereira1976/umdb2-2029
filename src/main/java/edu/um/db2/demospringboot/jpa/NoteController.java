package edu.um.db2.demospringboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @PostMapping("/note")
    public void save(@RequestBody Note note) {
        noteRepository.save(note);
    }
}
