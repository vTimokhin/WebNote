package com.example.webnote;

import com.example.webnote.models.Note;
import com.example.webnote.models.User;
import com.example.webnote.services.NoteService;
import com.example.webnote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WebNoteApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebNoteApplication.class, args);
    }
}
