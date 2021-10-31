package com.example.webnote.services.database;

import com.example.webnote.models.Note;
import com.example.webnote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteService noteService;

    @Override
    public List<Note> findAll() {
        return noteService.findAll();
    }

    @Override
    public Note save(Note note) {
        return noteService.save(note);
    }

    @Override
    public List<Note> saveAll(List<Note> notes) {
        return noteService.saveAll(notes);
    }

    @Override
    public Note getById(Integer id) {
        return noteService.getById(id);
    }
}
