package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "El nombre del alumno no puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar en mayúscula")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "El estudiante debe tener al menos una materia")
    List<SubjectDTO> subjects;
}
