package com.joyeria.joyeria.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Set;

public class MessageException {

    private String message;
    private int status;
    private String timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<InvalidValidationMessage> invalidValidations;

    public MessageException(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
    }

    public MessageException(String message, int status, Set<InvalidValidationMessage> invalidValidations) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
        this.invalidValidations = invalidValidations;
    }
}


