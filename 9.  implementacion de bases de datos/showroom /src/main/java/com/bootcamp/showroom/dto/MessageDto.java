package com.bootcamp.showroom.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto {
    private String message;
    private String action;
    private Integer statusCode;
}
