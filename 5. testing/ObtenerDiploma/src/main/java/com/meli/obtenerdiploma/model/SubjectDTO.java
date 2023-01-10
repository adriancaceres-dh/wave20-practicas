package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacio")
    @Size(max = 50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres")
    String name;

    @NotNull(message = "La nota de la materia no puede estar vacia")
    @DecimalMax(value = "10", message = "La nota maxima de la materia es de 10")
    @Min(value = 0, message = "La nota mínima de la materia es 0")
    Double score;
}
