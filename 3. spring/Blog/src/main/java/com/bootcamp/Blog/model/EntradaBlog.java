package com.bootcamp.Blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private Long id;
    private String tituloDelBlog;
    private String NombreDelAutor;
    private LocalDate FechaDePublicacion = LocalDate.now();

}
