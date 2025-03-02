package com.example.demo.Entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "journal_entries")
@Data
public class JournalEntity {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

    public JournalEntity() {
        this.date = LocalDateTime.now();
    }

    public JournalEntity(ObjectId id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
    }

}





