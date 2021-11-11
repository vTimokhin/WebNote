package com.example.webnote.services.database;

import com.example.webnote.models.Note;
import com.example.webnote.repositories.NoteRepository;
import com.example.webnote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> findAllByUser_Id(Integer id) {
        return noteRepository.findAllByUser_Id(id);
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> saveAll(List<Note> notes) {
        return noteRepository.saveAll(notes);
    }

    @Override
    public Note getById(Integer id) {
        return noteRepository.getById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        noteRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        noteRepository.deleteById(id);
    }
}