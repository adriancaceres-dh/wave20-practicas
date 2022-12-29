package com.example.DTO.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    private String full_name;
    private List<SymptomDTO> symptoms;

    public PersonDTO(String full_name, List<SymptomDTO> symptoms) {
        this.full_name = full_name;
        this.symptoms = symptoms;
    }
}
