package com.bootcamp.elastic_empleados.controller;

import com.bootcamp.elastic_empleados.dto.EmpleadoDTO;
import com.bootcamp.elastic_empleados.service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/create")
    public EmpleadoDTO crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.crearEmpleado(empleadoDTO);
    }

    @PutMapping("/update")
    public EmpleadoDTO actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.actualizarEmpleado(empleadoDTO);
    }

    @GetMapping("/{id}")
    public EmpleadoDTO traerEmpleadoPorId(@PathVariable String id) {
        return empleadoService.traerPorId(id);
    }
}
