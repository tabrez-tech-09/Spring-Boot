package com.example.demo.Entity;

import java.time.LocalDateTime;  // ✅ सही import किया

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal_entries")
public class JournalEntity {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;  // ✅ Data type ठीक किया

    public JournalEntity() {
        this.date = LocalDateTime.now();  // ✅ Default Date Set किया
    }

    public JournalEntity(ObjectId id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();  // ✅ Constructor में date set किया
    }

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}




