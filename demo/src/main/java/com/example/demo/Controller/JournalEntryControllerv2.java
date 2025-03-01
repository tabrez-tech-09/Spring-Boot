package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.JournalEntity;
import com.example.demo.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntity> getAll() {
        return journalEntryService.getAllEntries();
    }

    @PostMapping
    public JournalEntity create(@RequestBody JournalEntity myEntity) {  
        myEntity.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntity);
        return myEntity;
    }

    @GetMapping("/id/{myid}")
    public Optional<JournalEntity> getJournalEntityById(@PathVariable ObjectId myid) {  
        return journalEntryService.getEntryById(myid);
    }

    @DeleteMapping("/id/{myid}")
    public String deleteJournalEntityById(@PathVariable ObjectId myid) {  
        return journalEntryService.deleteEntry(myid);
    }

    @PutMapping("/id/{id}")
    public JournalEntity updateJournalEntityById(@PathVariable ObjectId id, @RequestBody JournalEntity myEntity) {  
        return journalEntryService.updateEntry(id, myEntity);
    }
}



