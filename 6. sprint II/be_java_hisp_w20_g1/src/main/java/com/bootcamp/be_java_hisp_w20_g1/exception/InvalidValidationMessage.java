package com.bootcamp.be_java_hisp_w20_g1.exception;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InvalidValidationMessage {
    private String rejectedValue;
    private String reason;

    public InvalidValidationMessage(String rejectedValue, String reason) {
        this.rejectedValue = rejectedValue;
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvalidValidationMessage that = (InvalidValidationMessage) o;
        return Objects.equals(rejectedValue, that.rejectedValue) && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rejectedValue, reason);
    }
}

