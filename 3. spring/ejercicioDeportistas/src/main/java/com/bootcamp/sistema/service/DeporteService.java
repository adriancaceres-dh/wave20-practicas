package com.bootcamp.sistema.service;

import com.bootcamp.sistema.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class DeporteService {

    private List<Deporte> deportes;

    public DeporteService() {
        deportes = new ArrayList<>();

        deportes.add(new Deporte("Volley", "Intermedio"));
        deportes.add(new Deporte("Hockey", "Principiante"));
        deportes.add(new Deporte("Tennis", "Intermedio"));
        deportes.add(new Deporte("Ajedrez", "Avanzado"));

    }

    public List<Deporte> devolverTodos(){
        return deportes;
    }

    public ResponseEntity<String> devolverPorNombre(String nombre){
        Deporte deporteEncontrado = deportes.stream().filter(e -> e.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
        if (deporteEncontrado==null) return new ResponseEntity<>("No se ha encontrado el deporte ingresado o el mismo no existe", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Deporte encontrado: " + deporteEncontrado.getNombre() + " con el nivel: " + deporteEncontrado.getNivel(), HttpStatus.OK);
        /*try {
            return new ResponseEntity<>("Deporte encontrado: " + deporteEncontrado.getNombre() + " con el nivel: " + deporteEncontrado.getNivel(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("No se ha encontrado el deporte ingresado o el mismo no existe", HttpStatus.BAD_REQUEST);
        }*/
    }
}
