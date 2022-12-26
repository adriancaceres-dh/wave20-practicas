package com.bootcamp.calorias.controller;

import com.bootcamp.calorias.dto.request.RequestPlatoDTO;
import com.bootcamp.calorias.dto.response.ResponsePlatoDTO;
import com.bootcamp.calorias.service.CaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CaloriasController {

    @Autowired
    private CaloriasService caloriasService;

    @PostMapping("/procesar")
    public ResponseEntity<List<ResponsePlatoDTO>> procesarPlato (@RequestBody List<RequestPlatoDTO> requestPlatoDTO){
        List<ResponsePlatoDTO> responsePlatoDTOS = new ArrayList<>();
        requestPlatoDTO.forEach(r -> {
            responsePlatoDTOS.add(caloriasService.procesarPlato(r));
        });
        return ResponseEntity.ok().body(responsePlatoDTOS);
    }

}
