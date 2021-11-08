package com.example.webnote.services;

import com.example.webnote.models.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    List<User> saveAll(List<User> users);

    // Получение по id
    User getById(Integer id);

    User findByLogin(String login);

    User findByMail(String email);

    Integer deleteUserById(Integer userID);

    Integer deleteUsersAll();

    List<User> findAllByDelete();
}
