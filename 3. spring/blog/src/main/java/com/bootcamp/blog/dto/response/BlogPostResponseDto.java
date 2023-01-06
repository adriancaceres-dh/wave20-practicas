package com.bootcamp.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogPostResponseDto {
    private String id;
    private String title;
    private String authorName;
    private LocalDate date;
}
