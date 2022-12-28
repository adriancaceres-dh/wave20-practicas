package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlogResponseDto {
    private String id;
    private String titulo;
    private String nombre;
    private LocalDate fecha_publicacion;
}
