package com.example.webnote.repositories;

import com.example.webnote.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByUser_Id(Integer id);
    void deleteById (Integer id);
}
