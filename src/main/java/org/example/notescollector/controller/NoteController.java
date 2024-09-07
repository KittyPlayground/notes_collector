package org.example.notescollector.controller;

import org.example.notescollector.dto.impl.NoteDTO;
import org.example.notescollector.util.AppUtil;
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
    //Json object aka serialization karagan oni
   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)

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
