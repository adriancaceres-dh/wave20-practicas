package com.bootcamp.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class BlogExceptionDto {
    private final String message;

    public BlogExceptionDto(String message) {
        this.message = message;
    }
}
