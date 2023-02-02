package com.bootcamp.deportistas.Service;

import com.bootcamp.deportistas.DTOs.DeporteDTO;
import com.bootcamp.deportistas.Model.Deporte;
import com.bootcamp.deportistas.Repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeporteServiceImp implements IDeporteService{
@Autowired
private DeporteRepository deporteRepo;

    @Override
    public List<DeporteDTO> findAllSports() {
        return deporteRepo.getDeportes().stream()
                .map(d -> new DeporteDTO(d.getNombre(), d.getNivel()))
                .collect(Collectors.toList());
    }

    @Override
    public DeporteDTO findSport(String name) {
        Optional<Deporte> deporte = deporteRepo.getDeportes().stream()
                .filter(d-> d.getNombre().equals(name)).findAny();

        if(deporte.isPresent()){
            DeporteDTO deporteDTO = new DeporteDTO();
            deporteDTO.setNombre(deporte.get().getNombre());
            deporteDTO.setNivel(deporte.get().getNivel());
            return deporteDTO;
        } else {
            return  null;
        }
    }
}
