package org.example.notescollector.service;

import org.example.notescollector.dto.impl.NoteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Override
    public String saveNote(NoteDTO noteDTO) {
        return "";
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return List.of();
    }

    @Override
    public NoteDTO getSelectedNotes(String noteId) {
        return null;
    }

    @Override
    public String deleteNote(String noteId) {
        return "";
    }

    @Override
    public String update(NoteDTO noteDTO) {
        return "";
    }
}
