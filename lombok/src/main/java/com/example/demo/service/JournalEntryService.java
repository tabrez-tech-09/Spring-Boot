package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.JournalEntity;
import com.example.demo.Repository.JournalEntryRepo;

@Service
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public List<JournalEntity> getAllEntries() {
        return journalEntryRepo.findAll();
    }

    public void saveEntry(JournalEntity entry) {
        journalEntryRepo.save(entry);
    }

    public Optional<JournalEntity> getEntryById(ObjectId id) {  
        return journalEntryRepo.findById(id);
    }

    public String deleteEntry(ObjectId id) {  
        journalEntryRepo.deleteById(id);
        return "Deleted Successfully";
    }

    public JournalEntity updateEntry(ObjectId id, JournalEntity entry) { 
        entry.setId(id);
        return journalEntryRepo.save(entry);
    }
}




