package com.bootcamp.blog.dto;

public class IdNotFoundResponseDto {
    
    private String id;

    private String message;

    public IdNotFoundResponseDto(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

   

    
}
