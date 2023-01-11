package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no debe estar vacío.")
    @Pattern(regexp = "[A-ZÁ-Ú][A-Za-zá-ú ]*", message = "El nombre de la materia debe empezar con mayúscula.")
    @Size(max = 50, message = "El nombre de la materia no debe superar los 30 caracteres")
    String name;
    @NotNull(message = "La nota no debe estar vacia.")
    @Min(value = 0, message = "La nota minima debe ser 0.")
    @Max(value = 10, message = "La nota maxima debe ser 10.")
    Double score;
}
