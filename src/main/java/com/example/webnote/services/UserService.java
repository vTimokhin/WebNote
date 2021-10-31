package com.example.webnote.services;

import com.example.webnote.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    List<User> saveAll(List<User> users);

    // Получение по id
    User getById(Integer id);
}
