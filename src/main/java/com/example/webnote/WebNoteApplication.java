package com.example.webnote;

import com.example.webnote.models.User;
import com.example.webnote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;
import java.util.Collections;

import static com.example.webnote.models.User.Role.ADMIN;
import static com.example.webnote.models.User.Role.USER;
import static com.example.webnote.models.User.Status.ACTIVE;

@SpringBootApplication
public class WebNoteApplication {
//    @Autowired
//    private UserService userService;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void applicationReady() {
//        userService.saveAll(Arrays.asList(
//                new User(0, "admin", "admin", "admin", "admin@mail.ru",
//                        ACTIVE, Collections.singleton(ADMIN), null),
//                new User(0, "user", "user", "user", "user@mail.ru",
//                        ACTIVE, Collections.singleton(USER), null)
//        ));
//    }

    public static void main(String[] args) {
        SpringApplication.run(WebNoteApplication.class, args);
    }
}
