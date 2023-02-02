package com.bootcamp.deportistas.Service;

import com.bootcamp.deportistas.DTOs.DeporteDTO;
import com.bootcamp.deportistas.DTOs.DeportistaDTO;
import com.bootcamp.deportistas.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepo;
    private  final ModelMap mapper = new ModelMap();
    @Override
    public List<DeportistaDTO> getDeportistas() {
        List<DeportistaDTO> dtoList = personaRepo.getPersonas().stream()
                .map(p -> new DeportistaDTO(p.getNombre(),p.getApellido(),p.getDeporte().getNombre()))
                .collect(Collectors.toList());
        return  dtoList;
    }
}
