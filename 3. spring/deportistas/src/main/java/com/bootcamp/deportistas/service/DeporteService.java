package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.PersonaDeporteDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.repository.IDeporteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService implements IDeporteService{

    @Autowired
    IDeporteRepository iDeporteRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public List<PersonaDeporteDTO> getPersonaDeporte() {
        return iDeporteRepository.getDeporte().stream()
                .map(d -> mapper.map(d, PersonaDeporteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<Deporte> getDeporte() {
        return iDeporteRepository.getDeporte().stream().map(d-> mapper.map(d, Deporte.class)).collect(Collectors.toList());
    }

    @Override
    public Deporte getDeporteByName(String nombreDeporte) {
        return iDeporteRepository.getDeporteByName(nombreDeporte);

    }


}
