package com.bootcamp.deportistas.Controller;

import com.bootcamp.deportistas.DTOs.DeporteDTO;
import com.bootcamp.deportistas.Service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {
    @Autowired
    private IDeporteService deporteService;
    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> allSports(){
        return ResponseEntity.ok(deporteService.findAllSports());
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> oneSport(@PathVariable String name){
        return ResponseEntity.ok(deporteService.findSport(name));
    }
}
