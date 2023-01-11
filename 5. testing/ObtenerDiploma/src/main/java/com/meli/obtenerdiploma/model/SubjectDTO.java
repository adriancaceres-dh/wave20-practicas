package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @NotNull(message = "El nombre de la materia no puede estar vacío.")
    String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value = 0, message = "La mínima nota es 0.0.")
    @Max(value = 10, message = "La maximo nota es 10.0.")
    Double score;
}
