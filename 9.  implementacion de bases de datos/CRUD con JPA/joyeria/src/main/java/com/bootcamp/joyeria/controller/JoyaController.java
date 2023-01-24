package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.request.JoyaDTORequest;
import com.bootcamp.joyeria.dto.response.JoyaDTOResponse;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<JoyaDTOResponse> addJewel(@RequestBody JoyaDTORequest joyaDTO) {
        return new ResponseEntity<>(joyaService.addJewel(joyaDTO), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaDTOResponse>> getJewels() {
        return new ResponseEntity<>(joyaService.getJewels(), HttpStatus.OK);
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<JoyaDTOResponse> updateJewel(@RequestBody JoyaDTORequest joyaDTO, @PathVariable Long id_modificar) {
        return new ResponseEntity<>(joyaService.updateJewel(joyaDTO, id_modificar), HttpStatus.OK);
    }

    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.deleteJewel(id), HttpStatus.OK);
    }
}
