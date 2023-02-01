package com.empleados.EmpleadosElastic.service;

import com.empleados.EmpleadosElastic.domain.Empleado;
import com.empleados.EmpleadosElastic.elasticrepositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository articuloRepository;

    @Override
    public String save(Empleado empleado) {
        articuloRepository.save(empleado);
        return "se agrego un empleado";
    }

    public List<Empleado> getAllByEdad(String edad){
        return articuloRepository.findByEdad(edad);
    }

    public List<Empleado> getByNombre(String nombre){
        return articuloRepository.findByNombreContains(nombre);
    }

    public List<Empleado> getByLoQueSea(String nombre, String edad){
        return articuloRepository.findByNombreEqualsAndEdadEquals(nombre, edad);
    }
}
