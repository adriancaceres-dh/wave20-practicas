package com.meli.obtenerdiploma.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;


import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
@AllArgsConstructor

public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp="^[A-Z]", message="el nombre del alumno debe comenzar con mayúscula")
    @Size(max = 50 , message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacia")
    List<SubjectDTO> subjects;
}
