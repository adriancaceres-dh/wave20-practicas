package com.bootcamp.Covid19.dto;

import com.bootcamp.Covid19.controlador.Enfermedad;
import com.bootcamp.Covid19.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@AllArgsConstructor
public class PersonaSintomaDTO {
    private String fullName;
    private Sintoma sintoma;

    public PersonaSintomaDTO() {
    }
}
