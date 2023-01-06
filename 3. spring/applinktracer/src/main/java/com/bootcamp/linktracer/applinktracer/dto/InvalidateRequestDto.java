package com.bootcamp.linktracer.applinktracer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvalidateRequestDto {
    private String password;
}
