package com.bootcamp.qa_testers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDTO {
    private String message;
    private Object payload;

    public ResultDTO(String message) {
        this.message = message;
    }
}
