package com.bootcamp.blog.config;

import com.bootcamp.blog.exceptions.BlogNotFoundException;
import com.bootcamp.blog.exceptions.DuplicatedBlogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<String> blogNotFound(BlogNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(DuplicatedBlogException.class)
    public ResponseEntity<String> duplicatedBlog(DuplicatedBlogException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }


}