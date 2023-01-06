package com.meli.obtenerdiploma.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidValidationMessage {
    private String field;
    private String rejectedValue;
    private String reason;

    public InvalidValidationMessage(String field, String rejectedValue, String reason) {
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.reason = reason;
    }
}

