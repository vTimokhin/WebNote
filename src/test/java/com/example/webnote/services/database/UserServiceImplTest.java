package com.example.webnote.services.database;

import com.example.webnote.models.User;
import com.example.webnote.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Test
    void findAll() {
    }

    @Test
    void save() {
        User user = new User("L1", "P1", "N1", "m1@mail.ru", User.Status.ACTIVE);
        user = userService.save(user);
        Assert.notNull(user, "not user");
        Assert.state(userService.getById(user.getId()).getId() == user.getId(), "not user");
    }

    @Test
    void saveAll() {
        List<User> users = Arrays.asList(
                new User("L2", "P2", "N2", "m2@mail.ru", User.Status.ACTIVE),
                new User("L3", "P3", "N3", "m3@mail.ru", User.Status.ACTIVE)
        );
        users = userService.saveAll(users);
        Assert.notNull(users, "not users");
    }

    @Test
    @Transactional
    void getById() {
        User user = new User("L4", "P4", "N4", "m4@mail.ru", User.Status.ACTIVE);
        user = userService.save(user);
        Assert.notNull(userService.getById(user.getId()), "не найден User по id");
        Assert.state(userService.getById(user.getId()).equals(user), "not id");
    }


    @Test
    @Transactional
    void findByLogin() {
        User user = new User("L5", "P5", "N5", "m5@mail.ru", User.Status.ACTIVE);
        user = userService.save(user);
        Assert.notNull(userService.findByLogin("L5"), "not user");
        Assert.state(userService.findByLogin(user.getLogin()).equals(user), "Не найден User по login");
    }

    @Test
    @Transactional
    void findByMail() {
        User user = new User("L6", "P6", "N6", "m6@mail.ru", User.Status.ACTIVE);
        user = userService.save(user);
        Assert.notNull(userService.findByMail("m6@mail.ru"), "Не найден User по email");
        Assert.state(userService.findByMail(user.getMail()).equals(user), "Не найден User по email");
    }

    @Test
    @Transactional
    void deleteUserById() {
        List<User> users = Arrays.asList(
                new User("L7", "P7", "N7", "m7@mail.ru", User.Status.ACTIVE),
                new User("L8", "P8", "N8", "m8@mail.ru", User.Status.ACTIVE),
                new User("L9", "P9", "N9", "m9@mail.ru", User.Status.ACTIVE),
                new User("L10", "P10", "N10", "m10@mail.ru", User.Status.ACTIVE)
        );
        users = userService.saveAll(users);
        Assert.notNull(userService.deleteUserById(users.get(0).getId()), "не удалено");
        Assert.state(userService.deleteUserById(users.get(3).getId()) == 1, "не удалено");
    }

    @Test
    @Transactional
    void deleteUsersAll() {
        List<User> users = Arrays.asList(
                new User("L7", "P7", "N7", "m7@mail.ru", User.Status.ACTIVE),
                new User("L8", "P8", "N8", "m8@mail.ru", User.Status.BLOCKED),
                new User("L9", "P9", "N9", "m9@mail.ru", User.Status.ACTIVE),
                new User("L10", "P10", "N10", "m10@mail.ru", User.Status.DELETED)
        );
        users = userService.saveAll(users);
        int del  = userService.deleteUsersAll();
        System.out.println(del);
        Assert.state(userService.deleteUsersAll() == 3, "не удалено");
    }

    @Test
    @Transactional
    void findAllByDelete() {
        List<User> users = Arrays.asList(
                new User("L7", "P7", "N7", "m7@mail.ru", User.Status.ACTIVE),
                new User("L8", "P8", "N8", "m8@mail.ru", User.Status.BLOCKED),
                new User("L9", "P9", "N9", "m9@mail.ru", User.Status.ACTIVE),
                new User("L10", "P10", "N10", "m10@mail.ru", User.Status.DELETED)
        );
        users = userService.saveAll(users);
        int del  = userService.deleteUsersAll();
        System.out.println(del);
        List<User> list = userService.findAllByDelete();
        list.forEach(System.out::println);
    }
}