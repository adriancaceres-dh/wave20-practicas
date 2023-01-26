package com.example.demo.controllers;

import com.example.demo.domain.Empleado;
import com.example.demo.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/empleados")
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @GetMapping("/empleados/{edad}")
    public List<Empleado> findByEdad(@PathVariable String edad){
        return empleadoService.getAllByEdad(edad);
    }
}
