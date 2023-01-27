package com.bootcamp.siniestrovehiculo.service;

import com.bootcamp.siniestrovehiculo.dto.MessageDTO;
import com.bootcamp.siniestrovehiculo.dto.SiniestroDTO;
import com.bootcamp.siniestrovehiculo.dto.VehiculoDTO;
import com.bootcamp.siniestrovehiculo.entity.Vehiculo;
import com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroExtendidoTemplate;
import com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroTemplate;
import com.bootcamp.siniestrovehiculo.exception.NotFoundException;
import com.bootcamp.siniestrovehiculo.repository.IVehiculoRepository;
import com.bootcamp.siniestrovehiculo.service.interfaces.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    IVehiculoRepository vehiculoRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public VehiculoDTO saveEntity(VehiculoDTO crudDTO) {
        var entity = mapper.map(crudDTO, Vehiculo.class);

        entity = vehiculoRepository.save(entity);

        return mapper.map(entity, VehiculoDTO.class);
    }

    @Override
    public VehiculoDTO getEntityById(Long id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new NotFoundException("El vehículo no existe");
        }
        var entity = vehiculoRepository.findById(id).get();
        return mapper.map(entity, VehiculoDTO.class);
    }

    @Override
    public List<VehiculoDTO> getAllEntities() {
        return vehiculoRepository.findAll().stream().map(s -> mapper.map(s, VehiculoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new NotFoundException("El vehículo no existe");
        }
        vehiculoRepository.deleteById(id);
        return MessageDTO.builder()
                .message("Se eliminó el vehículo con id:" + id)
                .action("DELETE")
                .build();
    }

    @Override
    public List<String> getPatentesVehiculo() {
        return vehiculoRepository.getPatentesVehiculo();
    }

    @Override
    public List<VehiculoSiniestroTemplate> getVehiculosSiniestroOrderByFabricacion() {
        return vehiculoRepository.getVehiculosSiniestroOrderByFabricacion();
    }

    @Override
    public List<String> getPatentesVehiculoCon4RuedasActual() {
        return vehiculoRepository.getPatentesVehiculoCon4RuedasActual();
    }

    @Override
    public List<VehiculoSiniestroTemplate> getVehiculosSiniestroConPerdidas10000() {
        return vehiculoRepository.getVehiculosSiniestroConPerdidas10000();
    }

    @Override
    public List<VehiculoSiniestroExtendidoTemplate> getVehiculosSiniestroTotalPerdidas() {
        return vehiculoRepository.getVehiculosSiniestroTotalPerdidas();
    }
}
