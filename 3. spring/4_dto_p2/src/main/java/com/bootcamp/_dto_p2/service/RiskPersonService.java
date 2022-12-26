package com.bootcamp._dto_p2.service;

import com.bootcamp._dto_p2.dto.PersonaDTO;
import com.bootcamp._dto_p2.dto.RiskPersonDTO;
import com.bootcamp._dto_p2.model.Persona;
import com.bootcamp._dto_p2.model.Sintoma;
import com.bootcamp._dto_p2.repository.PersonaRepository;
import com.bootcamp._dto_p2.repository.SintomaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RiskPersonService {

    public static List<RiskPersonDTO> getAllRiskPersonDTO(){
        List<Long> id_mayores= PersonaRepository.getAll().stream()
                .filter(persona -> persona.getEdad()>60)
                .map(mayor->mayor.getId())
                .sorted()
                .collect(Collectors.toList());
        List<Long> id_sintomaticos= new ArrayList<>();
        for(Sintoma sintoma: SintomaRepository.getAll()){
            for(Long id_sintomatico: sintoma.getId_sintomaticos()){
                if(!id_sintomaticos.contains(id_sintomatico)){
                    id_sintomaticos.add(id_sintomatico);
                }
            }
        }
        return id_sintomaticos.stream()
                .map(id->new RiskPersonDTO(PersonaRepository.getByID(id).getNombre(),PersonaRepository.getByID(id).getApellido()))
                .collect(Collectors.toList());

    }

}
