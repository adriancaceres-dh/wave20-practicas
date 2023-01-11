package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@AllArgsConstructor
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp="^[A-Z]", message="El nombre de la materia debe comenzar en mayúscula")
    @Size(max = 30 , message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;

    @Min(value = 0,message = "La mínima nota es 0")
    @Max(value = 10,message = "La máxima nota es 10")
    Double score;
}
