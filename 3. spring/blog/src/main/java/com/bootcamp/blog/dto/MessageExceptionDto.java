package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageExceptionDto {
    private String message;
    private String timestamp;

    public MessageExceptionDto(String message) {
        this.message = message;
        this.timestamp = LocalDate.now().toString();
    }
}
