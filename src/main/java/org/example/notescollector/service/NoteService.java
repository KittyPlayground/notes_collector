package org.example.notescollector.service;

import org.example.notescollector.dto.NoteStatus;
import org.example.notescollector.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {

    void saveNote(NoteDTO noteDTO);
    List <NoteDTO> getAllNotes();
    NoteStatus getSelectedNotes (String noteId);
    void deleteNote(String noteId);
    void update (String noteId, NoteDTO noteDTO);

}
