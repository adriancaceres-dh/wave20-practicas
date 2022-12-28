package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.IdNotFoundResponseDto;

import lombok.Getter;

@Getter
public class IdNotFoundException extends RuntimeException {
    

    private IdNotFoundResponseDto idNotFound;

    public IdNotFoundException(IdNotFoundResponseDto idNotFound) {
        this.idNotFound = idNotFound;
    }    
    
    
}
