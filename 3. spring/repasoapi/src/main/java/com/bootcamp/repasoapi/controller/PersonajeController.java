package com.bootcamp.repasoapi.controller;

import com.bootcamp.repasoapi.model.Personaje;
import com.bootcamp.repasoapi.service.PersonajesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajeController {

    private PersonajesService personajesService;

    public PersonajeController() {
        personajesService = new PersonajesService();
    }

    @GetMapping(value ={"personajes","/personajes/{empresa}"})
    public List<Personaje> todos(
            @PathVariable(required = false) String empresa,
            @RequestParam(required = false) String nombre
    ) {
        return personajesService.todos(empresa, nombre);
    }

    @PostMapping("/personaje")
    public String agregar(@RequestBody Personaje personaje) {
        return personajesService.agregar(personaje);
    }


}


