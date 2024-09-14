package org.example.notescollector.service;

import org.example.notescollector.dto.impl.NoteDTO;
import org.example.notescollector.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    private static List<NoteDTO> noteDTOList = new ArrayList<>();

    NoteServiceImpl(){
        noteDTOList.add(new NoteDTO("NOTE-7cb9a5ba-b4c7-4625-9c60-630762e141bb","science","hi","20240910","P1","1"));
        noteDTOList.add(new NoteDTO("NOTE-7cb9a5ba-b4c7-4625-9c60-630762e141bc","cinema","hii","20240910","P2","2"));
        noteDTOList.add(new NoteDTO("NOTE-7cb9a5ba-b4c7-4625-9c60-630762e141be","tech","hiii","20240910","P3","3"));
    }

    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        noteDTOList.add(noteDTO);
        return noteDTO;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteDTOList;
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
