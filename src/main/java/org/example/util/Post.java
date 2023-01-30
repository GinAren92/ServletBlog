package org.example.util;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private final String id;
    private final LocalDateTime date;
    private final String title;
    private final String content;
    private final String author;

    public Post(){
        title=null;
        content=null;
        author=null;
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
