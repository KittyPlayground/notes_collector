package org.example.notescollector.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notescollector.entity.SuperEntity;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "note")
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createDate;
    private String priorityLevel;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity user;
}
