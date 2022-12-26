package com.dto.covid.service;

import com.dto.covid.model.SymptomM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SymptomS {
   List<SymptomM> symptomList;


    public SymptomS() {
        SymptomM cough = new SymptomM(1, "Tós", "Leve");
        SymptomM soreBody = new SymptomM(2, "Dolor de cuerpo ", "Moderado");
        SymptomM soreThroat = new SymptomM(3, "Dolor de garganta", "Leve");
        SymptomM lossBreath = new SymptomM(4, "Dificultada para respirar", "Grave");
        symptomList = Arrays.asList(cough,soreBody,soreThroat, lossBreath);

    }

    public String printList () {
        StringBuilder listToString = new StringBuilder("La lista de síntomas es: \n");
        symptomList.forEach(item -> listToString.append(item.toString()));
        listToString.append(("________________"));
        return listToString.toString();
    }

    public String findOneByName(String name){
        List<SymptomM> result = symptomList.stream().filter(item -> item.getName().equals(name)).collect(Collectors.toList());

        try{
           return result.get(0).toString();
        }catch(Exception e){
            return "El síntoma buscado no existe.";
        }
    }


    public SymptomM findOneByCode(int code){
        List<SymptomM> result = symptomList.stream().filter(item -> item.getCode()==code).collect(Collectors.toList());

        try{
            return result.get(0);
        }catch(Exception e){
            return new SymptomM();
        }
    }
}
