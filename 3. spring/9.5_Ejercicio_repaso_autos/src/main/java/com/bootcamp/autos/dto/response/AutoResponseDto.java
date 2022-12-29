package com.bootcamp.autos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutoResponseDto {
    private String id;
    private String marca;
    private String modelo;
}
