package com.bootcamp.siniestrovehiculo.service;

import com.bootcamp.siniestrovehiculo.dto.MessageDTO;
import com.bootcamp.siniestrovehiculo.dto.SiniestroDTO;
import com.bootcamp.siniestrovehiculo.entity.Siniestro;
import com.bootcamp.siniestrovehiculo.entity.Vehiculo;
import com.bootcamp.siniestrovehiculo.exception.NotFoundException;
import com.bootcamp.siniestrovehiculo.repository.ISiniestroRepository;
import com.bootcamp.siniestrovehiculo.repository.IVehiculoRepository;
import com.bootcamp.siniestrovehiculo.service.interfaces.ISiniestroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroService implements ISiniestroService {

    @Autowired
    ISiniestroRepository siniestroRepository;

    @Autowired
    IVehiculoRepository vehiculoRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public SiniestroDTO saveEntity(SiniestroDTO crudDTO) {
        var entity = mapper.map(crudDTO, Siniestro.class);

        Vehiculo vehiculo = vehiculoRepository.findById(crudDTO.getVehiculo().getId()).get();
        entity.setVehiculo(vehiculo);

        entity = siniestroRepository.save(entity);

        return mapper.map(entity, SiniestroDTO.class);
    }

    @Override
    public SiniestroDTO getEntityById(Long id) {
        if (!siniestroRepository.existsById(id)) {
            throw new NotFoundException("El siniestro no existe");
        }
        var entity = siniestroRepository.findById(id).get();
        return mapper.map(entity, SiniestroDTO.class);
    }

    @Override
    public List<SiniestroDTO> getAllEntities() {
        return siniestroRepository.findAll().stream().map(s -> mapper.map(s, SiniestroDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        if (!siniestroRepository.existsById(id)) {
            throw new NotFoundException("El siniestro no existe");
        }
        siniestroRepository.deleteById(id);
        return MessageDTO.builder()
                .message("Se eliminó el siniestro con id:" + id)
                .action("DELETE")
                .build();
    }
}
