package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @Size(max=50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @NotBlank(message= "El nombre del alumno no puede estar vacio.")
    @Pattern(regexp = "^[A-Z].+$", message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message= "La lista no puede estar vacia.")
    @Valid
    List<SubjectDTO> subjects;
}
