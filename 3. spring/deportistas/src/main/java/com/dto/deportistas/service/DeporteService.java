package com.dto.deportistas.service;

import com.dto.deportistas.model.DeporteModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeporteService {
    private List<DeporteModel> listaDeportes;

    public DeporteService() {
        DeporteModel futbolA = new DeporteModel("Fútbol", "Avanzado");
        DeporteModel natacionA = new DeporteModel("Natación", "Avanzado");
        DeporteModel golfA = new DeporteModel("Golf", "Avanzado");
        listaDeportes = Arrays.asList(natacionA, futbolA, golfA);
    }

    public List<DeporteModel> getListaDeportes() {
        return listaDeportes;
    }

    public void setListaDeportes(List<DeporteModel> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }

    @Override
    public String toString() {
        StringBuilder stringListaDeportes = new StringBuilder();
        listaDeportes.forEach(deporte -> stringListaDeportes.append(deporte.toString()).append(", ").append('\n'));
        return  "listaDeportes: {" + '\n' +
                stringListaDeportes + '\n' +
                '}';
    }

    public String buscarDeporte(String name){
        System.out.println(name);
        try{
            DeporteModel deporteEncontrado = listaDeportes.stream().filter(deporte -> deporte.getNombre().equals(name)).collect(Collectors.toList()).get(0);
            return "El deporte consultado es de nivel "+deporteEncontrado.getNivel() ;
        }catch(Exception e){
            return "El deporte consultado no existe";
        }
    }
}
