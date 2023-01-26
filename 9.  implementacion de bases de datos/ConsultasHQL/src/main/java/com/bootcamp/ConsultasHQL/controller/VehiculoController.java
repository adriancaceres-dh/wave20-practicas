package com.bootcamp.ConsultasHQL.controller;

import com.bootcamp.ConsultasHQL.dto.request.VehiculoResquestDTO;
import com.bootcamp.ConsultasHQL.dto.response.VehiculoResponseDTO;
import com.bootcamp.ConsultasHQL.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/")
    public ResponseEntity<VehiculoResponseDTO> create(@RequestBody VehiculoResquestDTO dto){
        return ResponseEntity.ok(vehiculoService.create(dto));
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getAllPatentes(){
        return ResponseEntity.ok(vehiculoService.findAllPatentes());
    }

    @GetMapping("/patenteYMarca")
    public ResponseEntity<?> getPatenteMarca(){
        return ResponseEntity.ok(vehiculoService.findPatenteMarcaOrderByAnoFabricacion());
    }

    @GetMapping("/patenteByRueadas")
    public ResponseEntity<?> getPatenteByRuedas(@RequestParam Integer ruedas){
        return ResponseEntity.ok(vehiculoService.findPatentesByRuedasYAno(ruedas));
    }

    @GetMapping("/patenteMarcaModeloBySiniestro")
    public ResponseEntity<?> getPatenteMarcaModeloBySiniestro(){
        return ResponseEntity.ok(vehiculoService.findPatenteMarcaModeloBySiniestro());
    }
}
