package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(min = 0, max = 50, message = "La longitud del nombre de materia no puede superar los 50 caracteres.")
    String name;

    @NotNull(message = "La nota no puede estar vacía")
    @DecimalMax(value = "10.0", message = "La nota máxima es 10.0")
    @DecimalMin(value = "0.0", message = "La nota mínima es 0.0")
    Double score;
}
