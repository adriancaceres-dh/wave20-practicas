package com.wave20.ejercicio_covid19.service;

import com.wave20.ejercicio_covid19.dto.PersonaDTO;
import com.wave20.ejercicio_covid19.dto.PersonaSintomaDTO;
import com.wave20.ejercicio_covid19.dto.SintomaDTO;
import com.wave20.ejercicio_covid19.model.Sintoma;
import com.wave20.ejercicio_covid19.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    private static Map<PersonaDTO, List<SintomaDTO>> personaConSintomas = new HashMap<>();

    public static List<PersonaSintomaDTO> getPersonasConSintomas() {
        //se agrega una entrada al mapa con un solo sintoma a modo de prueba de funcionamiento.
        List<SintomaDTO> sintomas = new ArrayList<>();
        List<PersonaSintomaDTO> personasConSintomas =  new ArrayList<>();
        sintomas.add(new SintomaDTO(1, "Dolor", "alto"));
        personaConSintomas.put(new PersonaDTO(1, "Kar", "Hoffman", 64), sintomas);
        Iterator<Map.Entry<PersonaDTO, List<SintomaDTO>>> it = personaConSintomas.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<PersonaDTO, List<SintomaDTO>> entry = it.next();
            if (entry.getKey().getEdad() >= 60) {
                personasConSintomas.add(new PersonaSintomaDTO(entry.getKey().getNombre(), entry.getKey().getApellido(),
                        entry.getValue().get(0).getNombre()));
            }

        }

        return personasConSintomas;
    }


}
