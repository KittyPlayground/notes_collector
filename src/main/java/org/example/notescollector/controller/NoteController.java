package org.example.notescollector.controller;

import org.example.notescollector.dto.impl.NoteDTO;
import org.example.notescollector.service.NoteService;
import org.example.notescollector.service.NoteServiceImpl;
import org.example.notescollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    NoteService noteService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, //serialization
                produces = MediaType.APPLICATION_JSON_VALUE )//deserialization

   public String saveNotes(@RequestBody NoteDTO noteDTO) {
       noteDTO.setNoteId(AppUtil.generateNoteId());
       return "note save success";

   }
   public NoteDTO getSelectedNotes() {
        return null;

    }
    public List<NoteDTO> getAllNotes() {
        return null;
    }
    public void deletedNotes() {

    }
    public void updateNotes(String noteId,NoteDTO noteDTO) {

    }

}
