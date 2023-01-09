package com.meli.obtenerdiploma.exception;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MessageForException {
    private String message;
    private int status;
    private String timestamp;
    private List<InvalidValidationMessage> invalidValidations;

    public MessageForException(String message, int status, List<InvalidValidationMessage> invalidValidations) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
        this.invalidValidations = invalidValidations;
    }

    public MessageForException(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
    }
}
