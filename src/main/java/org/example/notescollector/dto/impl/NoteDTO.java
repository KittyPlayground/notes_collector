package org.example.notescollector.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notescollector.dto.NoteStatus;
import org.example.notescollector.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements NoteStatus, SuperDTO {

    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createDate;
    private String priorityLevel;
    private String userId;
}
