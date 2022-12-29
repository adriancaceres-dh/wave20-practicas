package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.request.AutoRequestDto;
import com.bootcamp.autos.dto.response.AutoResponseDto;
import com.bootcamp.autos.exception.IdAlreadyExistException;
import com.bootcamp.autos.model.Auto;
import com.bootcamp.autos.repository.AutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoService implements IAutoService{

    private final ModelMapper mapper = new ModelMapper();

    public AutoService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }
    @Autowired
    AutoRepository autoRepository;

    @Override
    public List<AutoResponseDto> getAutos() {
        return autoRepository.getAutos().stream()
                .map(auto -> mapper.map(auto,AutoResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String agregarAuto(AutoRequestDto autoRequestDto) {
        if( !buscarId(autoRequestDto) && autoRepository.agregar(mapper.map(autoRequestDto,Auto.class))) {
            return "Alta ok";
        } else {
            throw new IdAlreadyExistException("No se pudo agregar");
        }
    }

    public boolean buscarId(AutoRequestDto autoRequestDto) {
        return autoRepository.getAutos().stream()
                .anyMatch(auto -> auto.getId().equals(autoRequestDto.getId()));
    }

}
