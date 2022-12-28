package com.example.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntryRequestDto implements Serializable {
    private Long id;
    private String title;
    private String author;
    private String creationDate;
}
