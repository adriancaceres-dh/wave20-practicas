package com.bootcamp.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogRequestDTO {
    private Long id;
    private String tituloDelBlog;
    private String nombreDelAutor;
    private LocalDate fechaDePublicacion = LocalDate.now();
}
