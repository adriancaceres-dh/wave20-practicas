package com.example.demo.service;

import com.example.demo.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomaService {

    List<Sintoma> sintomaList = new ArrayList<>();

    public SintomaService() {
        rellenar();
    }

    public void rellenar(){
        sintomaList.add(new Sintoma(0, "Fiebre", "Grave"));
        sintomaList.add(new Sintoma(1, "Dolor", "Leve"));
        sintomaList.add(new Sintoma(2, "Hematuria", "Leve"));
    }

    public List<Sintoma> getSintomaList() {
        return sintomaList;
    }

    public void setSintomaList(List<Sintoma> sintomaList) {
        this.sintomaList = sintomaList;
    }

    public Sintoma findSymptomByName(String sintoma){
        for(Sintoma s: sintomaList) if(s.getNombre().equals(sintoma)) return s;
        return new Sintoma();
    }
}
