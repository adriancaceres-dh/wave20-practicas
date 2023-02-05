package com.example.demo.controllers;

import com.example.demo.domain.Empleado;
import com.example.demo.services.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/empleados")
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @GetMapping("/empleados/{edad}")
    public List<Empleado> findByEdad(@PathVariable String edad){
        return empleadoService.getAllByEdad(edad);
    }

    @PatchMapping("/update-empleados/{id}")
    public Empleado update(@PathVariable String id, String nombre, String edad, String ciudad, String provincia){
        return empleadoService.update(id, nombre, edad, ciudad, provincia);
    }

}
