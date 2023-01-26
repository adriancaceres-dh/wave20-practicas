package com.example.demo.exception;

import com.example.demo.dto.MessageDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NotFoundException extends Exception{

    private MessageDto message;
}
