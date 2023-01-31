package com.bootcamp.vehicles.controller;

import com.bootcamp.vehicles.dto.AccidentDTO;
import com.bootcamp.vehicles.dto.MessageDTO;
import com.bootcamp.vehicles.service.accident.IAccidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accidents")
public class AccidentController {

    private final IAccidentService accidentService;

    public AccidentController(IAccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @PostMapping
    ResponseEntity<MessageDTO> createAccident(@RequestBody AccidentDTO accidentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accidentService.createAccident(accidentDTO));
    }

    @GetMapping
    ResponseEntity<List<AccidentDTO>> getAccidents() {
        return ResponseEntity.status(HttpStatus.OK).body(accidentService.getAllAccidents());
    }
}
