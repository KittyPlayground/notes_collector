package org.example.notescollector.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notescollector.dto.NoteStatus;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SelectedNoteErrorStatus implements NoteStatus {
    private int statusCode;
    private  String statusMessage;
}
