package com.bootcamp.BlogYoutuber.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {

    int id;
    String titulo;
    String nombreAutor;
    LocalDate fechaPublicacion;

}
