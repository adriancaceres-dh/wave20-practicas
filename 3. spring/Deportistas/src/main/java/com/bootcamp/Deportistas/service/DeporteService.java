package com.bootcamp.Deportistas.service;

import com.bootcamp.Deportistas.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
public class DeporteService {
    private List<Deporte> deporteList;

    public DeporteService(){

        deporteList = new ArrayList<>();
        deporteList.add(new Deporte("Tenis", "Medio"));
        deporteList.add(new Deporte("Natacion", "Medio"));
    }

    public List<Deporte> findSports (){
        return deporteList;
    }

    public ResponseEntity<String> findSport (String name){
        try {
            Deporte deporte = deporteList.stream().filter(deporte1 -> deporte1.getNombre().equals(name)).findFirst().orElse(null);
            assert deporte != null;
            return new ResponseEntity<>(deporte.getNivel(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
