package com.example.demo.services;

import com.example.demo.domain.Empleado;
import com.example.demo.elasticrepositories.EmpleadoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }
    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
    @Override
    public List<Empleado> getAllByEdad(String edad){
        return empleadoRepository.findByEdad(edad);
    }

    @Override
    public Empleado update(String id, String nombre, String edad, String ciudad, String provincia) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el empleado")
        );
        empleado.setNombre(nombre);
        empleado.setEdad(edad);
        empleado.setCiudad(ciudad);
        empleado.setProvincia(provincia);
        empleadoRepository.save(empleado);
        return empleado;
    }
}
