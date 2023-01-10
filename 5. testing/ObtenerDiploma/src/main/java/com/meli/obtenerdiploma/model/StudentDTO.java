package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank( message = "Name must not be blank")
    @Size(max = 50 , message = "Name maximus length is 50 charters" )
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = "List must no be empty")
    List< @Valid SubjectDTO> subjects;
}
