package com.DTOyResponseEntityP2PG.Deportistas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
@RestController
public class Deportistas {
    Map<Persona,Deporte> deps = new HashMap<>();

    public Deportistas(Map<Persona, Deporte> deportistas) {
        this.deps = deportistas;
    }
    @GetMapping("/inscribir")
    public void inscribirDeportistas() {
        Deporte deporte = new Deporte("Futbol", 5);
        Persona persona = new Persona("Santiago", "Valdez", 25);
        Map <Persona,Deporte> relacion = new HashMap<Persona,Deporte>();
        Deportistas deportista = new Deportistas(relacion);
    }

    @GetMapping("/mostrar")
    public Map<Persona, Deporte> getDeps() {
        return deps;
    }
}
