package com.bootcamp.be_java_hisp_w20_g6.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ErrorResponseDto {
    private String name;
    private String description;

}
