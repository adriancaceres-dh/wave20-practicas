package com.spring.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EntradaBlog {
    private String id;
    private String titulo;
    private String nombre;
    private LocalDate fechaPublicacion;
}
