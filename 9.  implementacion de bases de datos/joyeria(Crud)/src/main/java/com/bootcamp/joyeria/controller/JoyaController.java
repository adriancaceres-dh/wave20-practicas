package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.request.JoyaDTORequest;
import com.bootcamp.joyeria.service.JoyaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class JoyaController {

    @Autowired
    private JoyaServiceImpl joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> create(@RequestBody JoyaDTORequest joyaDTO){
        return ResponseEntity.ok().body(joyaService.save(joyaDTO));
    }

    @GetMapping("/jewerly")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(joyaService.getAll());
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.ok().body(joyaService.delete(id));
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<?> update(@RequestBody JoyaDTORequest joyaDTORequest, @PathVariable Integer id_modificar){
        return ResponseEntity.ok().body(joyaService.update(joyaDTORequest, id_modificar));
    }
}
