package com.bootcamp.testers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class MessageDto {
       private String message;
       private String action;
}
