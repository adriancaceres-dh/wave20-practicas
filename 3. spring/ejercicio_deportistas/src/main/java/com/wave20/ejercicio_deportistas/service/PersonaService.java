package com.wave20.ejercicio_deportistas.service;

import com.wave20.ejercicio_deportistas.DTO.DeporteDTO;
import com.wave20.ejercicio_deportistas.DTO.PersonaDTO;
import com.wave20.ejercicio_deportistas.DTO.PersonaDeporteDTO;
import com.wave20.ejercicio_deportistas.model.Deporte;
import com.wave20.ejercicio_deportistas.model.Persona;
import com.wave20.ejercicio_deportistas.repository.DeporteRepository;
import com.wave20.ejercicio_deportistas.repository.PersonaRepository;

import java.util.*;

public class PersonaService {

    private static PersonaRepository personaRepository;
    private static Map<PersonaDTO, DeporteDTO> personaDeportes = new HashMap<>();

    public static void agregarPersonaDeportista(PersonaDTO p, DeporteDTO d) {
        personaDeportes.put(p, d);
    }

    public static List<PersonaDeporteDTO> mostarPersonasDeportistas() {
        //Se agrega una entrada al mapa a modo de ejemplo de uso ya que falta mapear la persona y el deporte con los
        //dto incluidos en la linea siguiente.
        personaDeportes.put(new PersonaDTO("Pedro", "Gomez", 32), new DeporteDTO("Futbol", "bajo"));
        List<PersonaDeporteDTO> personasDeportistas = new ArrayList<>();
       for (Map.Entry<PersonaDTO, DeporteDTO> entry : personaDeportes.entrySet()) {
            personasDeportistas.add(new PersonaDeporteDTO(entry.getKey().getNombre(),
                    entry.getKey().getApellido(), entry.getValue().getNivel()));
       }
       return personasDeportistas;
    }



}
