package com.example.webnote.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "users")
public class User {
    public enum Status {
        ACTIVE,
        BLOCKED,
        DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 10)
    private String login;
    @Column(nullable = false, length = 10)
    private String pass;
    @Column(nullable = false, length = 20)
    private String nickName;
    @Column(nullable = false, length = 20)
    private String mail;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Note> notes;

    public User(String login, String pass, String nickName, String mail, Status status) {
        this.login = login;
        this.pass = pass;
        this.nickName = nickName;
        this.mail = mail;
        this.status = status;
    }
}