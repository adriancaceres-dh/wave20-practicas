package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "El nombre de la materia no puede superar los 30 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar en mayúscula")
    String name;
    @NotEmpty(message = "La nota no puede estar vacía")
    @Max(value = 10, message = "La nota no puede ser mayor a 10.0")
    @Min(value = 0, message = "La nota no puede ser menor a 0.0")
    Double score;

}
