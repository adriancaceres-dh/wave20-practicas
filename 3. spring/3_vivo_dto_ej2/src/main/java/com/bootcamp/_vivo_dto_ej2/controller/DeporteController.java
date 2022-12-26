package com.bootcamp._vivo_dto_ej2.controller;

import com.bootcamp._vivo_dto_ej2.model.Deporte;
import com.bootcamp._vivo_dto_ej2.repository.DeporteRepository;
import com.bootcamp._vivo_dto_ej2.view.DeporteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DeporteController {

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        List<DeporteDTO> deportesDTO = DeporteRepository.getAll().stream()
                .map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(deportesDTO,HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> getSportLevel(@PathVariable String name){
        if(DeporteRepository.existeDeporte(name)) {
            return new ResponseEntity<String>(DeporteRepository.getDeporteByName(name).getNivel(), HttpStatus.OK);
        }else {
            return new ResponseEntity<String>("No se encontro el deporte solicitado.",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/findSports")
    public ResponseEntity<Boolean> addSport(@RequestBody Deporte deporte){
        Boolean ok = DeporteRepository.addDeporte(deporte);
        return new ResponseEntity<>(ok, (ok)? HttpStatus.OK : HttpStatus.INSUFFICIENT_SPACE_ON_RESOURCE);
    }
}
