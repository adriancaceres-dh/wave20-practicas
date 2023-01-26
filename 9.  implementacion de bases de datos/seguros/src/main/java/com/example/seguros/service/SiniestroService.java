package com.example.seguros.service;

import com.example.seguros.dto.MensajeDto;
import com.example.seguros.dto.SiniestroDto;
import com.example.seguros.dto.VehiculoDto;
import com.example.seguros.dto.templates.TemplateMatriculaMarcaYModelo;
import com.example.seguros.model.Siniestro;
import com.example.seguros.model.Vehiculo;
import com.example.seguros.repository.SiniestroRepository;
import com.example.seguros.repository.VehiculoRepository;
import com.example.seguros.service.interfaces.ISiniestroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroService implements ISiniestroService {


    private SiniestroRepository siniestroRepository;
    private VehiculoRepository vehiculoRepository;

    public SiniestroService(SiniestroRepository siniestroRepository, VehiculoRepository vehiculoRepository) {
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    private ModelMapper modelmapper = new ModelMapper();

    @Override
    public SiniestroDto newEntity(SiniestroDto dto) {
        var entity = modelmapper.map(dto, Siniestro.class);
        var vehiculo = vehiculoRepository.findById(dto.getVehiculo().getIdVehiculo()).get();
        entity.setVehiculo(vehiculo);
        siniestroRepository.save(entity);
        return modelmapper.map(entity,SiniestroDto.class);
    }
    @Override
    public List<TemplateMatriculaMarcaYModelo> getAllMarcaModeloPatente() {
        return siniestroRepository.getVehiculoBySiniestro();
    }

    @Override
    public List<String> getAllEntities() {
        return null;
    }

    @Override
    public SiniestroDto getEntityById(Integer integer) {
        return null;
    }

    @Override
    public SiniestroDto updateEntity(SiniestroDto dto, Integer integer) {
        return null;
    }

    @Override
    public MensajeDto deleteEntity(Integer integer) {
        return null;
    }
}
