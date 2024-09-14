package org.example.notescollector.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notescollector.entity.SuperEntity;

import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "user")

public class UserEntity implements SuperEntity {
    @Id
    private String UserID;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String profilePic;
    @OneToMany(mappedBy = "user")
    private List<NoteEntity> notes;
}
