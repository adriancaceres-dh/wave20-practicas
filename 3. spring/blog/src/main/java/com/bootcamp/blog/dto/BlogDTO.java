package com.bootcamp.blog.dto;

import com.bootcamp.blog.model.BlogEntry;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BlogDTO {
    private long blogId;
    private String title;
    private String authorName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publishDate;

    public BlogDTO() {
    }

    public BlogDTO(BlogEntry blogEntry) {
        blogId = blogEntry.getId();
        title = blogEntry.getTitle();
        authorName = blogEntry.getAuthorName();
        publishDate = blogEntry.getPublishDate();
    }
}
