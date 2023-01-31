package com.example.demo.services;

import com.example.demo.domain.Empleado;

import java.util.List;

public interface EmpleadoService {

     String save(Empleado empleado);
    List<Empleado> getAllByEdad(String edad);

    List<Empleado> getByNombre(String nombre);

    List<Empleado> getByLoQueSea(String firstname, String lastname);
}
