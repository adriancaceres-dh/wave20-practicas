package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre es obligatorio")
    @Max(value = 50,message = "El nombre no puede contener mas de 50 caracteres")
    @Pattern(regexp = "[A-Z]\\w*", message = "El nombre debe comenzar con mayuscula.")
    String name;
    @NotNull(message = "El score es obligatorio")
    @Min(value = 0,message = "La nota minima es 0.0")
    @Max(value = 10,message = "La nota maxima es 10.0")
    Double score;
}
