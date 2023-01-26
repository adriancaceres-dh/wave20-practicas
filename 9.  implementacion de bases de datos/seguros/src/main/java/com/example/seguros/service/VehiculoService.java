package com.example.seguros.service;

import com.example.seguros.dto.MensajeDto;
import com.example.seguros.dto.VehiculoDto;
import com.example.seguros.dto.VehiculoSimpleDto;
import com.example.seguros.dto.templates.TemplateMarcaYPatente;
import com.example.seguros.dto.templates.TemplateMatriculaMarcaYModelo;
import com.example.seguros.model.Vehiculo;
import com.example.seguros.repository.VehiculoRepository;
import com.example.seguros.service.interfaces.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {
    private VehiculoRepository vehiculoRepository;
    private ModelMapper modelmapper = new ModelMapper();

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoSimpleDto newEntity(VehiculoSimpleDto dto) {
        var entity = modelmapper.map(dto,Vehiculo.class);
        vehiculoRepository.save(entity);
        return modelmapper.map(entity,VehiculoSimpleDto.class);
    }

    @Override
    public List<String> getAllEntities() {
        return vehiculoRepository.getAllPatentes();
    }
    @Override
    public List<TemplateMarcaYPatente> getAllPatenteAndMarca() {
        return vehiculoRepository.getAllPatentesAndMarca();
    }
    @Override
    public List<VehiculoDto> getAllByCantRuedas() {
        return vehiculoRepository.getVehiculoByCantRuedas().stream()
                .map(v-> modelmapper.map(v,VehiculoDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public VehiculoSimpleDto getEntityById(Integer integer) {
        return null;
    }

    @Override
    public VehiculoSimpleDto updateEntity(VehiculoSimpleDto dto, Integer integer) {
        return null;
    }

    @Override
    public MensajeDto deleteEntity(Integer integer) {
        return null;
    }
}
