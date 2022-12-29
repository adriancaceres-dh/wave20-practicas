package com.example.DTO.Repository;

import com.example.DTO.Models.Symptom;
import com.example.DTO.dto.SymptomDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SymptomRepository {
    private List<Symptom> symptoms;
    public SymptomRepository() {
        symptoms= new ArrayList<>();
        symptoms.add(new Symptom(1, "tos", "GRAVE"));
        symptoms.add(new Symptom(2, "fiebre", "LEVE"));
        symptoms.add(new Symptom(3, "sarpullido", "MEDIO"));
        symptoms.add(new Symptom(4, "mareo", "GRAVE"));

    }
}
