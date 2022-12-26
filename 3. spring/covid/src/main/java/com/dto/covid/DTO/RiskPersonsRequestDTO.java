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
                "personFirstName='" + personFirstName + '\n' +
                ", personLastName='" + personLastName + '\n' +
                "}\n";
    }

    public List<RiskPersonsRequestDTO> getRiskPersons (){
        PersonSymptomS personSymptom = new PersonSymptomS();
        PersonS personS = new PersonS();
        SymptomS symptomS = new SymptomS();

        List<RiskPersonsRequestDTO> personsAtRisk = new ArrayList<>();

        personSymptom.getPersonSymptomList().forEach((personId, listSymptoms)-> {
           PersonM auxPerson = personS.findOneById(personId);

           if(auxPerson.getAge()>=60) personsAtRisk.add(new RiskPersonsRequestDTO(auxPerson.getFirstName(), auxPerson.getLastName()));
        });

    return personsAtRisk;
    }


    public String printList(){
        List<RiskPersonsRequestDTO> personsAtRisk = getRiskPersons();
        StringBuilder listToString = new StringBuilder("La lista de síntomas es: \n");
        personsAtRisk.forEach(item -> listToString.append(item.toString()));
        listToString.append(("________________"));
        return listToString.toString();
    }
}
