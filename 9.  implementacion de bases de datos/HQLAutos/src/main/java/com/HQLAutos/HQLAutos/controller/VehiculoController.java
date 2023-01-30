package com.HQLAutos.HQLAutos.controller;

import com.HQLAutos.HQLAutos.DTO.MarcaYPatenteDTO;
import com.HQLAutos.HQLAutos.DTO.MatriculaMarcaYModeloDTO;
import com.HQLAutos.HQLAutos.model.Vehiculo;
import com.HQLAutos.HQLAutos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("vehiculos/patentes")
    public List<String> getPatentes(){
        return vehiculoService.getPatentes();
    }
    @GetMapping("vehiculos/marcaYPatentes")
    public List<MarcaYPatenteDTO> getMarcaYPatentes(){
        return vehiculoService.getMarcaYPatente();
    }
    @PostMapping("vehiculos/new")
    public String createVehiculo(@RequestBody Vehiculo vehiculo){
        return vehiculoService.createVehiculo(vehiculo);
    }
    @GetMapping("vehiculos/patentes4Ruedas")
    public List<String> getVehiculos4Ruedas(){
        return vehiculoService.getPatentesVehiculos4RuedasYFechaActual();
    }
    @GetMapping("vehiculos/siniestrosMayoresA10000")
    public List<MatriculaMarcaYModeloDTO> getVEhiculosPerdidaMayorA10000(){
        return vehiculoService.getVehiculosPerdidaMayorA10000();
    }
}
