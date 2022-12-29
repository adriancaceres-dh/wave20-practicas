package com.DTOyResponseEntity.DTOyResponseEntity.controller;

import com.DTOyResponseEntity.DTOyResponseEntity.model.Deporte;
import com.DTOyResponseEntity.DTOyResponseEntity.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {
    private DeporteService deporteService;
    public DeporteController() {
        deporteService = new DeporteService();
    }
    @GetMapping("/findSports")
    public List<Deporte> todosLosDeportes(){
        return deporteService.getTodosLosDeportes();

    }
    @GetMapping("findSport/{name}")
    public ResponseEntity<Deporte> buscarDeporte(@PathVariable String name){
         Deporte deporte = deporteService.buscarPorNombre(name);
         if (deporte == null){
             return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<>(deporte,HttpStatus.OK);
    }
}
