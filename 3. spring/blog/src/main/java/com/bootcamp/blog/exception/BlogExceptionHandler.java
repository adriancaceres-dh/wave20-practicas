package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.NotFoundDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class BlogExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        NotFoundDto notFoundDto = new NotFoundDto(e.getMessage(),false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundDto);
    }

    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<?> duplicateIdException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
