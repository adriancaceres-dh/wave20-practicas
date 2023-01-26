package com.example.demo.services;

import com.example.demo.domain.Empleado;
import com.example.demo.elasticrepositories.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository articuloRepository;

    @Override
    public Empleado save(Empleado empleado) {
        return articuloRepository.save(empleado);
    }

    public List<Empleado> getAllByEdad(String edad){
        return articuloRepository.findByEdad(edad);
    }

    @Override
    public List<Empleado> getAllByNombre(String nombre) {
        return articuloRepository.findByNombre(nombre);
    }
}
