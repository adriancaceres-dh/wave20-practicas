package com.bootcamp.claseDos.controller;

import com.bootcamp.claseDos.model.Personaje;
import com.bootcamp.claseDos.service.PersonajesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajeController {

    private PersonajesService personajesService;

    public PersonajeController() {
        personajesService = new PersonajesService();
    }

    @GetMapping(value={"/personajes","/personajes/{empresa}"})
    public List<Personaje> todos(@PathVariable(required = false) String empresa){
        if(empresa == null){
            return personajesService.todos();
        }else{
            return personajesService.porEmpresa(empresa);
        }
    }

    @PostMapping("/personaje")
    public String agregar(@RequestBody Personaje personaje){
        if(personajesService.agregar(personaje)){
            return "Agregado";
        }else{
            return "No agregado";
        }

    }

}
