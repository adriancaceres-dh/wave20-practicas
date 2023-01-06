package com.meli.obtenerdiploma.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MessageForException {
    private String message;
    private int status;
    private String timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<InvalidValidationMessage> invalidValidations;

    public MessageForException(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
    }

    public MessageForException(String message, int status, List<InvalidValidationMessage> invalidValidations) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
        this.invalidValidations = invalidValidations;
    }
}
