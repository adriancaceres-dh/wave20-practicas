package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;


@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre no debe estar vacío.")
    @Pattern(regexp = "[A-ZÁ-Ú][A-Za-zá-ú ]*", message = "El nombre debe empezar con mayúscula.")
    @Size(max = 50, message = "El nombre no debe superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no debe estar vacía.")
    List<SubjectDTO> subjects;
}
