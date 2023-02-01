package com.empleados.EmpleadosElastic.controller;

import com.empleados.EmpleadosElastic.domain.Empleado;
import com.empleados.EmpleadosElastic.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/empleados")
    public String save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @GetMapping("/empleados/{edad}")
    public List<Empleado> findByEdad(@PathVariable String edad){
        return empleadoService.getAllByEdad(edad);
    }

    @GetMapping("/empleados/byname/{nombre}")
    public List<Empleado> findByNombre(@PathVariable String nombre){
        return empleadoService.getByNombre(nombre);
    }

    @GetMapping("/empleados/bycompletename")
    public List<Empleado> findByLoQueSea(@RequestParam String nombre, @RequestParam String edad){
        return empleadoService.getByLoQueSea(nombre, edad);
    }
}
