package com.bootcamp.be_java_hisp_w20_g1.exception;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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

