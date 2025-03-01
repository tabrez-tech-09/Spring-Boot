package com.example.demo.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.JournalEntity;

@Repository
public interface JournalEntryRepo extends MongoRepository<JournalEntity, ObjectId> {
}



