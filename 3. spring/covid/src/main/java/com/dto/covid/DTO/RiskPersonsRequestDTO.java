package com.dto.covid.DTO;

import com.dto.covid.model.PersonM;
import com.dto.covid.service.PersonS;
import com.dto.covid.service.PersonSymptomS;
import com.dto.covid.service.SymptomS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RiskPersonsRequestDTO {

    String personFirstName;
    String personLastName;


    public RiskPersonsRequestDTO() {
    }

    public RiskPersonsRequestDTO(String personFirstName, String personLastName){
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    @Override
    public String toString() {
        return "{" + '\n' +
                "Nombre: " + personFirstName + '\n' +
                "Apellido: " + personLastName + '\n' +
                "}\n";
    }

}
