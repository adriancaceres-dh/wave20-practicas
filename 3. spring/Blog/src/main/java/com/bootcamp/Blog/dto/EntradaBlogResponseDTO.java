package com.bootcamp.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlogResponseDTO {
    private String tituloDelBlog;
    private String nombreDelAutor;
    private String fechaDePublicacion;
}
