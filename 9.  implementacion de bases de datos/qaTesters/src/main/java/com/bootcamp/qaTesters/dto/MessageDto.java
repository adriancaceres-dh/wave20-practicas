package com.bootcamp.qaTesters.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto {
    private String mesage;
    private String action;
}
