package com.bootcamp.elastic_empleados.util;

import com.bootcamp.elastic_empleados.dto.EmpleadoDTO;
import com.bootcamp.elastic_empleados.model.Empleado;

public interface IEmpleadoMapper {
    EmpleadoDTO toDTO(Empleado empleado);

    Empleado fromDTO(EmpleadoDTO empleadoDTO);
}
