package com.example.webnote.services.database;

import com.example.webnote.models.User;
import com.example.webnote.repositories.UserRepository;
import com.example.webnote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findByMail(String email) {
        return userRepository.findByMail(email);
    }

    @Override
    public Integer deleteUserById(Integer userID) {
        return userRepository.deleteUserById(userID);
    }

    @Override
    public Integer deleteUsersAll() {
        return userRepository.deleteUsersAll();
    }

    @Override
    public List<User> findAllByDelete() {
        return userRepository.findAllByDelete();
    }
}
