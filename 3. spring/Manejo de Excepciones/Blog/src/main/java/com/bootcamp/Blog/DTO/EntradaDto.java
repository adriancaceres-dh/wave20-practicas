package com.bootcamp.Blog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/* Esta clase es creada para poder separar lo que es el ID del objeto EntradaBlog, ya que el usuario no debería setear
 * el ID del objeto, sino que este va a ser asignado manualmente dentro de nuestra API*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaDto {
    private String tituloBlog;
    private String nombreAutor;
    private LocalDate fechaPublicación;
}
