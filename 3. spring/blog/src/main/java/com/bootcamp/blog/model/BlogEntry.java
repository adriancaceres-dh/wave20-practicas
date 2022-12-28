package com.bootcamp.blog.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BlogEntry {
    private long id;
    private String title;
    private String authorName;
    private LocalDate publishDate;
    private LocalDateTime lastModified;
    private LocalDateTime createdAt;

    public BlogEntry(long id, String title, String authorName, LocalDate publishDate) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.publishDate = publishDate;
        lastModified = LocalDateTime.now();
        createdAt = LocalDateTime.now();
    }
}
