package com.bootcamp.Blog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaDto {
    private String tituloBlog;
    private String nombreAutor;
    private LocalDate fechaPublicación;
}
