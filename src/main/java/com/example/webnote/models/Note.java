package com.example.webnote.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false, length = 50)
    private String header;
    @Column
    private String text;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "notes_user",
            joinColumns = @JoinColumn(
                    name = "note_id", nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", nullable = false)
    )
    private User user;

    public Note(LocalDate date, String header, String text) {
        this.date = date;
        this.header = header;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(date, note.date) && Objects.equals(header, note.header) && Objects.equals(text, note.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, header, text);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", date=" + date +
                ", header='" + header + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}