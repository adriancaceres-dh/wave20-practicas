package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "El nombre es obligatorio")
    @Max(value = 50,message = "El nombre no puede contener mas de 50 caracteres")
    @Pattern(regexp = "[A-Z]\\w*", message = "El nombre debe comenzar con mayuscula.")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede estar vacia")
    List<SubjectDTO> subjects;
}
