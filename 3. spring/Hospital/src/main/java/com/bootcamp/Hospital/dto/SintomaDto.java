package com.bootcamp.Hospital.dto;

import com.bootcamp.Hospital.model.Persona;
import com.bootcamp.Hospital.model.Sintoma;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class SintomaDto implements Serializable {

    private String nobreCliente;
    private List<Sintoma> sintomas;
    private int edad;

    public SintomaDto(Persona persona){
        sintomas = new ArrayList<>();
        this.nobreCliente = persona.getNombre();
        this.sintomas = persona.getSintomas();
        this.edad = persona.getEdad();
    }

    public SintomaDto(){

    }
}
