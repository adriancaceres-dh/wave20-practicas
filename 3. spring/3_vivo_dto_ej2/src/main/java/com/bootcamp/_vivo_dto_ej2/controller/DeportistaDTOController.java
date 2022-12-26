package com.bootcamp._vivo_dto_ej2.controller;

import com.bootcamp._vivo_dto_ej2.model.Persona;
import com.bootcamp._vivo_dto_ej2.repository.DeporteRepository;
import com.bootcamp._vivo_dto_ej2.repository.PersonaRepository;
import com.bootcamp._vivo_dto_ej2.view.DeportistaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DeportistaDTOController {

    @GetMapping("/findSportsPersons")
    public static ResponseEntity<List<DeportistaDTO>> findSportsPersons(){

        List<Persona> personas = PersonaRepository.getAll().stream()
                                    .filter(persona -> persona.getId_deporte()!=-1)
                                    .collect(Collectors.toList());

        List<DeportistaDTO> deportistas = personas.stream()
                                            .map(persona -> new DeportistaDTO(persona.getNombre(), persona.getApellido(), DeporteRepository.getDeporteNameByID(persona.getId_deporte())))
                                            .filter(deportistaDTO -> deportistaDTO.getNombreDeporte()!=null)
                                            .collect(Collectors.toList());

        return new ResponseEntity<>(deportistas, HttpStatus.OK);

    }

}
