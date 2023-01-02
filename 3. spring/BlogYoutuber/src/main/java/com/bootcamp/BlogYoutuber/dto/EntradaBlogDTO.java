package com.bootcamp.BlogYoutuber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlogDTO {
    int id;
    String titulo;
    String nombreAutor;
    LocalDate fechaPublicacion;
}
