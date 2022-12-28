package com.example.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntryResponseDto implements Serializable {
    private String title;
    private String author;
    private String creationDate;
}