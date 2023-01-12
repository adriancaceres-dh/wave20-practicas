package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(message = "La longitud del nombre no puede superar los 30 caracteres.", max = 30)
    String name;

    @Min(value = 0, message = "La nota minima es de 0")
    @Max(value = 10, message = "la nota maxima es de 10")
    @NotNull(message = "la nota no puede estar vacia")
    Double score;
}
