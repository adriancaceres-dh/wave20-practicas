package com.bootcamp.clothes_no_relational.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageDTO {

    private Integer status;
    private String action;
    private String message;
}
