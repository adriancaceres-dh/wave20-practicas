package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.BlogExceptionDto;
import lombok.Getter;

@Getter
public class ExistingIdException extends RuntimeException {
    private final BlogExceptionDto blogExceptionDto;

    public ExistingIdException(BlogExceptionDto blogExceptionDto) {
        this.blogExceptionDto = blogExceptionDto;
    }
}
