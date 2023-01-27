package com.bootcamp.siniestrovehiculo.controller;

import com.bootcamp.siniestrovehiculo.dto.MessageDTO;
import com.bootcamp.siniestrovehiculo.dto.VehiculoDTO;
import com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroExtendidoTemplate;
import com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroTemplate;
import com.bootcamp.siniestrovehiculo.service.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("")
    public ResponseEntity<List<VehiculoDTO>> getAllVehiculos() {
        return ResponseEntity.ok(vehiculoService.getAllEntities());
    }

    @PostMapping("/new")
    public ResponseEntity<VehiculoDTO> createVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
        return ResponseEntity.ok(vehiculoService.saveEntity(vehiculoDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<VehiculoDTO> updateVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
        return ResponseEntity.ok(vehiculoService.saveEntity(vehiculoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> getVehiculoById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.getEntityById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteVehiculoById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.deleteEntity(id));
    }


    // Listar las patentes de todos los vehículos registrados.
    @GetMapping("/getAllPatentes")
    public ResponseEntity<List<String>> getPatentesVehiculo() {
        return ResponseEntity.ok(vehiculoService.getPatentesVehiculo());
    }

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @GetMapping("/getAllVehiculosSinietros")
    public ResponseEntity<List<VehiculoSiniestroTemplate>> getVehiculosSiniestroOrderByFabricacion() {
        return ResponseEntity.ok(vehiculoService.getVehiculosSiniestroOrderByFabricacion());
    }

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @GetMapping("/getAllPatentesMas4Ruedas")
    public ResponseEntity<List<String>> getPatentesVehiculoCon4RuedasActual() {
        return ResponseEntity.ok(vehiculoService.getPatentesVehiculoCon4RuedasActual());
    }

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/getAllVehiculosSinietrosGrandesPerdidas")
    public ResponseEntity<List<VehiculoSiniestroTemplate>> getVehiculosSiniestroConPerdidas10000() {
        return ResponseEntity.ok(vehiculoService.getVehiculosSiniestroConPerdidas10000());
    }

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    // y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @GetMapping("/getAllVehiculosSinietrosTotalPerdidas")
    public ResponseEntity<List<VehiculoSiniestroExtendidoTemplate>> getVehiculosSiniestroTotalPerdidas() {
        return ResponseEntity.ok(vehiculoService.getVehiculosSiniestroTotalPerdidas());
    }
}
