package com.example.persona.controller;

import com.example.persona.model.dtos.DeporteDto;
import com.example.persona.services.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.remote.rmi.RMIConnectionImpl_Stub;
import java.util.Collection;

@RestController
@RequestMapping("/sports")
public class DeporteController {
    private static DeporteService _service = new DeporteService();
@GetMapping("/findSports")
    public Collection<DeporteDto> findSports(){
        return _service.ObtenerDeportes();
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> findSportsByName(@PathVariable String name){
        String response = _service.ObtenerNivelDeDeporteByNombre(name);
        if(response!=null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
