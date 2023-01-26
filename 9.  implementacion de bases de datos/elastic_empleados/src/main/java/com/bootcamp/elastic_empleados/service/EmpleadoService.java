package com.bootcamp.elastic_empleados.service;

import com.bootcamp.elastic_empleados.dto.EmpleadoDTO;
import com.bootcamp.elastic_empleados.elastic_repositories.EmpleadoElasticRepository;
import com.bootcamp.elastic_empleados.util.EmpleadoMapper;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    private final EmpleadoMapper empleadoMapper;
    private final EmpleadoElasticRepository empleadoElasticRepository;

    public EmpleadoService(EmpleadoMapper empleadoMapper, EmpleadoElasticRepository empleadoElasticRepository) {
        this.empleadoMapper = empleadoMapper;
        this.empleadoElasticRepository = empleadoElasticRepository;
    }

    public EmpleadoDTO crearEmpleado(EmpleadoDTO empleadoDTO) {
        var empleado = empleadoMapper.fromDTO(empleadoDTO);
        empleado = empleadoElasticRepository.save(empleado);

        return empleadoMapper.toDTO(empleado);
    }

    public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO) {
        var empleado = empleadoMapper.fromDTO(empleadoDTO);
        if (empleado.getId() == null) {
            throw new RuntimeException("Debe indicarse el id del empleado a actualizar");
        }
        empleado = empleadoElasticRepository.save(empleado);

        return empleadoMapper.toDTO(empleado);
    }

    public EmpleadoDTO traerPorId(String id) {
        var empleado = empleadoElasticRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el empleado"));
        return empleadoMapper.toDTO(empleado);
    }
}
