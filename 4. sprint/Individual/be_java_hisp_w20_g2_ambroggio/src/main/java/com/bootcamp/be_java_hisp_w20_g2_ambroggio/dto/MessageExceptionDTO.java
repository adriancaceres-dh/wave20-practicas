package com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageExceptionDTO {
    private String message;
    private int httpCode;
    private String path;
    private LocalDateTime timestamp;
}
