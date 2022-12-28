package com.bootcamp.blog.dto;

import lombok.Getter;

@Getter
public class OperationResultDTO {
    private boolean success;
    private String message;

    public OperationResultDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public OperationResultDTO() {
    }
}
