package org.example.notescollector.controller;

import org.example.notescollector.customStatusCodes.SelectedNoteErrorStatus;
import org.example.notescollector.dto.NoteStatus;
import org.example.notescollector.dto.impl.NoteDTO;
import org.example.notescollector.entity.impl.NoteEntity;
import org.example.notescollector.exception.DataPersistException;
import org.example.notescollector.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, //serialization
            produces = MediaType.APPLICATION_JSON_VALUE)//deserialization

    public ResponseEntity<Void> saveNotes(@RequestBody NoteDTO noteDTO) {
        try {
            noteService.saveNote(noteDTO);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteStatus getSelectedNotes(@PathVariable("noteId") String noteId) {
       String regexForNoteId = "NOTE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
       Pattern regexPattern = Pattern.compile(regexForNoteId);
       var regexMatched = regexPattern.matcher(noteId); //check for valid note
       if (!regexMatched.matches()) {
           return new SelectedNoteErrorStatus(1, "Note Id cannot be null or empty");
       }
        return noteService.getSelectedNotes(noteId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes() {
        return noteService.getAllNotes();
    }
    @DeleteMapping(value = "/{noteId}")
    public ResponseEntity<Void> deletedNotes(@PathVariable("noteId") String noteId) {
        String regexForNoteId = "NOTE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
        try {
            if (!noteId.matches(regexForNoteId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            noteService.deleteNote(noteId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/{noteId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable("noteId") String noteId,
                           @RequestBody NoteDTO noteDTO) {


        noteService.update(noteId, noteDTO);


    }

}
