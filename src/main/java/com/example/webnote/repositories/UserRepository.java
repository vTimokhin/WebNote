package com.example.webnote.repositories;

import com.example.webnote.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);

    User findByMail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.status = '2' WHERE u.id = :id")
    Integer deleteUserById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.status = '2' WHERE u.status = '0' OR u.status = '1'")
    Integer deleteUsersAll();

    @Query("SELECT u FROM User u WHERE u.status = '2'")
    List<User> findAllByDelete();
}
