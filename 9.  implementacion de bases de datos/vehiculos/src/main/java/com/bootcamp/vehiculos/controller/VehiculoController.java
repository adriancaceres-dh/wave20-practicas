package com.bootcamp.vehiculos.controller;

import com.bootcamp.vehiculos.dto.VehiculoDTO;
import com.bootcamp.vehiculos.model.template.PatenteYMarca;
import com.bootcamp.vehiculos.service.VehiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    public List<String> listarPatentes() {
        return vehiculoService.listarPatentes();
    }

    @GetMapping("/patente_marca")
    public List<PatenteYMarca> listarPatentesYMarcas() {
        return vehiculoService.listarPatentesYMarcasPorAnio();
    }

    @PostMapping("/")
    public VehiculoDTO crearVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
        return vehiculoService.crearVehiculo(vehiculoDTO);
    }
}
