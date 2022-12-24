package com.bootcamp.Deportistas.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeportePersonaDTO implements Serializable {

    private String fullName;
    private List deportes;

    public DeportePersonaDTO() {

    }
}
