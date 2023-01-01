package com.bootcamp.Covid_19.services;

import com.bootcamp.Covid_19.dto.SintomaDTO;
import com.bootcamp.Covid_19.models.Sintoma;
import com.bootcamp.Covid_19.repository.SintomaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SintomaService {
    @Autowired
    SintomaRepository sintomaRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<SintomaDTO> getSintomas() {

        List<SintomaDTO> sintomasDTO = sintomaRepository.getListaDeSintomas().stream().map(sintoma -> modelMapper.map(sintoma, SintomaDTO.class)).collect(Collectors.toList());
        return sintomasDTO;
    }

    public String getSintomaByName(String name) {
        Optional<Sintoma> gravedad = sintomaRepository.getListaDeSintomas().stream().filter(sintoma -> sintoma.getNombre().equals(name)).findAny();
        if (gravedad.isPresent()) {
            return gravedad.get().getNivelDeGravedad();
        }else{
            throw new RuntimeException("Sintoma no encontrado");
        }
    }
}
