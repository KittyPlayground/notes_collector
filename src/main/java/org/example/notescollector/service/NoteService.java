package org.example.notescollector.service;

import org.example.notescollector.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {

    NoteDTO saveNote(NoteDTO noteDTO);
    List <NoteDTO> getAllNotes();
    NoteDTO getSelectedNotes (String noteId);
    String deleteNote(String noteId);
    String update (NoteDTO noteDTO);

}
