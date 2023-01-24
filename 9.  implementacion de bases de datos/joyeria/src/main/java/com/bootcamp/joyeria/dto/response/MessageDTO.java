package com.bootcamp.joyeria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageDTO {

    private Integer status;
    private String message;
}
