package org.example.notescollector.controller;

import org.example.notescollector.dto.impl.NoteDTO;
import org.example.notescollector.service.NoteService;
import org.example.notescollector.service.NoteServiceImpl;
import org.example.notescollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
     private NoteService noteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, //serialization
                produces = MediaType.APPLICATION_JSON_VALUE )//deserialization

   public NoteDTO saveNotes(@RequestBody NoteDTO noteDTO) {

       return noteService.saveNote(noteDTO);

   }
   public NoteDTO getSelectedNotes() {
        return null;

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes() {
        return noteService.getAllNotes();
    }
    public void deletedNotes() {

    }
    public void updateNotes(String noteId,NoteDTO noteDTO) {

    }

}
