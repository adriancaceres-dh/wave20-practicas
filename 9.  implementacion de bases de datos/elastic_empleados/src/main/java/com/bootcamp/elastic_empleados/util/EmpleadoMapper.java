package com.bootcamp.elastic_empleados.util;

import com.bootcamp.elastic_empleados.dto.EmpleadoDTO;
import com.bootcamp.elastic_empleados.model.Empleado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper implements IEmpleadoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public EmpleadoDTO toDTO(Empleado empleado) {
        return modelMapper.map(empleado, EmpleadoDTO.class);
    }

    @Override
    public Empleado fromDTO(EmpleadoDTO empleadoDTO) {
        return modelMapper.map(empleadoDTO, Empleado.class);
    }
}
