package com.dto.covid.controller;

import com.dto.covid.DTO.RiskPersonsRequestDTO;
import com.dto.covid.service.PersonSymptomS;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonC {

    PersonSymptomS riskPersonsRequestDTO;

    public PersonC() {
        riskPersonsRequestDTO = new PersonSymptomS();
    }
    @GetMapping("/findRiskPerson")
    public String findRiskPersons(){
        return riskPersonsRequestDTO.printList();
    }

}
