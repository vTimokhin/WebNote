package com.example.webnote.services;

import com.example.webnote.models.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAll();

    List<Note> findAllByUser_Id(Integer id);

    Note save(Note note);

    List<Note> saveAll(List<Note> notes);

    // Получение по id
    Note getById(Integer id);

    void deleteById(Integer id);

    void deleteAll();
}
