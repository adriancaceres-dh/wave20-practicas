package com.bootcamp.concesionaria.controller;

import com.bootcamp.concesionaria.dto.VehiculoConServiceDTO;
import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.service.ConcesionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ConcesionariaController {

    @Autowired
    ConcesionariaService concesionariaService;

    @PostMapping("/v1/api/vehicles")
    public ResponseEntity<VehiculoConServiceDTO> agregarVehiculo(@RequestBody VehiculoConServiceDTO vehiculoConServiceDTO){
        concesionariaService.cargarVehiculo(vehiculoConServiceDTO);
        return ResponseEntity.ok().body(vehiculoConServiceDTO);
    }

    @GetMapping("/v1/api/vehicles/{id}")
    public ResponseEntity<VehiculoConServiceDTO> getVehiculosPorPrecio(@PathVariable int id){
        return ResponseEntity.ok().body(concesionariaService.getVehiculo(id));
    }

    @GetMapping("/v1/api/vehicles")
    public ResponseEntity<List<VehiculoDTO>> getVehiculos(){
        return ResponseEntity.ok().body(concesionariaService.getVehiculos());
    }

    @GetMapping("/v1/api/vehicles/dates")
    public ResponseEntity<List<VehiculoDTO>> getVehiculosPorFecha(@RequestParam String since , @RequestParam String to){
        return ResponseEntity.ok().body(concesionariaService.getVehiculosPorFecha(since,to));
    }

    @GetMapping("/v1/api/vehicles/prices")
    public ResponseEntity<List<VehiculoDTO>> getVehiculosPorPrecio(@RequestParam int since , @RequestParam int to){
        return ResponseEntity.ok().body(concesionariaService.getVehiculosPorPrecio(since,to));
    }

}
