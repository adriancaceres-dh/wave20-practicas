package com.example.demo.controller;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.SinisterDto;
import com.example.demo.service.ISinisterService;
import com.example.demo.service.SinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinisters")
public class SinisterController {

    @Autowired
    SinisterService sinisterService;

    @PostMapping("/add")
    public ResponseEntity<SinisterDto> add(@RequestBody SinisterDto dto) {
        return ResponseEntity.ok(sinisterService.saveEntity(dto));
    }

    @GetMapping
    public ResponseEntity<List<SinisterDto>> getAll() {
        return ResponseEntity.ok(sinisterService.getAllEntities());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(sinisterService.deleteEntity(id));
    }

}
