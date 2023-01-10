package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;
    @Min(value = 0, message = "La nota minima es 0.0")
    @Max(value = 10, message = "La nota maxima es 10.0")
    @NotNull(message = "La nota no puede estar vacía")
    Double score;
}
