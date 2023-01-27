package com.bootcamp.products.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageDTO {

    private Integer status;
    private String action;
    private String message;
}
