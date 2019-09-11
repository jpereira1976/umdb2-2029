package edu.um.db2.demospringboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @PostMapping("/note")
    @RequestMapping(path="/note", method = RequestMethod.POST)
    public String save(@RequestBody Note note) {
        noteRepository.save(note);
        return "{\"id\":" + note.getId() + "}";
    }

    @PutMapping("/note/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Note note) {
        Note existingNote = noteRepository.getOne(id);
        existingNote.setContent(note.getContent());
        existingNote.setTitle(note.getTitle());
        noteRepository.save(existingNote);
    }

}
