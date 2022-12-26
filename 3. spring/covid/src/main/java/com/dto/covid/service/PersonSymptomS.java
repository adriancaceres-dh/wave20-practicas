package com.dto.covid.service;

import com.dto.covid.DTO.RiskPersonsRequestDTO;
import com.dto.covid.model.PersonM;

import java.util.*;

public class PersonSymptomS {

    Map<Integer, int[]> personSymptomList;

    public PersonSymptomS() {
        personSymptomList = new HashMap<>();
        personSymptomList.put(1, new int[]{2, 3});
        personSymptomList.put(3, new int[]{1, 2});
        personSymptomList.put(4, new int[]{3, 4});
    }

    public Map<Integer, int[]> getPersonSymptomList() {
        return personSymptomList;
    }

    public void setPersonSymptomList(Map<Integer, int[]> personSymptomList) {
        this.personSymptomList = personSymptomList;
    }


    public List<RiskPersonsRequestDTO> getRiskPersons (){
        PersonSymptomS personSymptom = new PersonSymptomS();
        PersonS personS = new PersonS();
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
