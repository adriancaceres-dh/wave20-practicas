package com.bootcamp.linktracker.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OperationResultDTO<T> {
    private Optional<T> result;
    private String message;
    private boolean isSuccesfull;
}
