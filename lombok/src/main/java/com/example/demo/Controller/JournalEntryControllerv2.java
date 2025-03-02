package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.JournalEntity;
import com.example.demo.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntity>> getAll() {
        List<JournalEntity> entries = journalEntryService.getAllEntries();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JournalEntity> create(@RequestBody JournalEntity myEntity) {  
        myEntity.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntity);
        return new ResponseEntity<>(myEntity, HttpStatus.CREATED);
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<?> getJournalEntityById(@PathVariable String myid) {  
        try {
            ObjectId objectId = new ObjectId(myid);
            Optional<JournalEntity> journalEntry = journalEntryService.getEntryById(objectId);

            if (journalEntry.isPresent()) {
                return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Journal Entry Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid ID Format", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<String> deleteJournalEntityById(@PathVariable String myid) {  
        try {
            ObjectId objectId = new ObjectId(myid);
            String result = journalEntryService.deleteEntry(objectId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid ID format", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateJournalEntityById(@PathVariable String id, @RequestBody JournalEntity myEntity) {  
        try {
            ObjectId objectId = new ObjectId(id);
            JournalEntity updatedEntity = journalEntryService.updateEntry(objectId, myEntity);
            if (updatedEntity != null) {
                return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Journal Entry Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid ID Format", HttpStatus.BAD_REQUEST);
        }
    }
}





