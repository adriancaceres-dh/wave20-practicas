package com.dto.covid.controller;

import com.dto.covid.DTO.RiskPersonsRequestDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonC {

    RiskPersonsRequestDTO riskPersonsRequestDTO;

    public PersonC() {
        riskPersonsRequestDTO = new RiskPersonsRequestDTO();
    }
    @GetMapping("/findRiskPerson")
    public String findRiskPersons(){
        return riskPersonsRequestDTO.printList();
    }

}
