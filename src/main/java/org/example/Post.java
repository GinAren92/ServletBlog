package org.example;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private String id;
    private LocalDateTime date;
    private String title;
    private String content;
    private String author;

    public Post(){
        date = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
    }
    public Post(String title, String content, String author){
        date = LocalDateTime.now();
        this.title = title;
        this.content = content;
        this.author = author;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
