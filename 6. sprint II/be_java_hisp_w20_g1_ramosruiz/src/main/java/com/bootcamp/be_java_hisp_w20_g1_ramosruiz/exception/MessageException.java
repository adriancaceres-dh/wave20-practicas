package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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
