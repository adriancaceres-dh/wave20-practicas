package com.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogPost {
    private String id;
    private String title;
    private String authorName;
    private LocalDate date;
}
