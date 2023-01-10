package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotBlank( message = "Name must not be blank")
    @Size(max = 30, message = "Name maximus length is 30 charters")
    String name;

    @NotNull
    @Min(value = 0, message = "The minimum score is 0.0")
    @Max(value = 10, message = "The maximum score is 10.0")
    Double score;
}
