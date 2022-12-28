package com.bootcamp._excepciones_p1_vivo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Blog {
    private String titulo,nombre;
    private LocalDate fechaPublicacion;

}
