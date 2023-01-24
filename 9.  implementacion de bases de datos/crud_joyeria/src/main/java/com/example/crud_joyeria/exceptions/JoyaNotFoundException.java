package com.example.crud_joyeria.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class JoyaNotFoundException extends RuntimeException {
    public JoyaNotFoundException(String message) {
        super(message);
    }
}
