package com.example.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageException {
    private String message;
    private String timestamp;

    public MessageException(String message) {
        this.message = message;
        this.timestamp = LocalDate.now().toString();
    }
}
