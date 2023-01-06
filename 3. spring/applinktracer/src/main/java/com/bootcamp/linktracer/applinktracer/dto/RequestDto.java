package com.bootcamp.linktracer.applinktracer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDto {

    private String url;
    private String password;
}
