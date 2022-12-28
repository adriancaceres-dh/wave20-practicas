package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntry {
    private Long id;
    private String title;
    private String author;
    private LocalDate creationDate;
}
