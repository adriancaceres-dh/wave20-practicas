package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Size(min = 1,max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp="[A-Z][a-z]*", message = "El nombre del alumno debe comenzar con mayúscula.")
    String studentName;

    String message;
    Double averageScore;

    @Size(min = 1, message = "La lista no puede ser vacía.")
    List<SubjectDTO> subjects;
}
