package com.ejercicio.Covid19.service;

import com.ejercicio.Covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SintomaService {

    private List<Sintoma> sintomas;

    public SintomaService(){
        sintomas = new ArrayList<>();
        sintomas.add(new Sintoma(1224,"viruela","Alto"));
        sintomas.add(new Sintoma(1228,"salmonela","Medio"));
        sintomas.add(new Sintoma(1230,"Resfriado","Bajo"));

    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public String buscarPorNombre(String name){
        List<Sintoma> sintomaEncontrado = new ArrayList<>();
        sintomaEncontrado = sintomas.stream().filter(x->x.getNombre().equalsIgnoreCase(name)).collect(Collectors.toList());
        if(sintomaEncontrado.isEmpty()){
            return "Sintoma no encontrado";
        }else{
            return sintomaEncontrado.get(0).getNivelDeGravedad();
        }
    }


}
