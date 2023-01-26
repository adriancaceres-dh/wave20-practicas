package com.bootcamp.vehiculos.util;

import com.bootcamp.vehiculos.dto.VehiculoDTO;
import com.bootcamp.vehiculos.model.Vehiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehiculoModelMapper implements IVehiculoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public VehiculoDTO toDTO(Vehiculo vehiculo) {
        return modelMapper.map(vehiculo, VehiculoDTO.class);
    }

    @Override
    public Vehiculo fromDTO(VehiculoDTO vehiculoDTO) {
        return modelMapper.map(vehiculoDTO, Vehiculo.class);
    }
}
