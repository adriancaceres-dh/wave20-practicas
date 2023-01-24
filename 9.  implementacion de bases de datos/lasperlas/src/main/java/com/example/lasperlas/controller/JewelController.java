package com.example.lasperlas.controller;

import com.example.lasperlas.dto.JewelOperationResponseDto;
import com.example.lasperlas.dto.JewelRequestDto;
import com.example.lasperlas.dto.JewelResponseDto;
import com.example.lasperlas.service.JewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    private final JewelService jewelService;

    public JewelController(JewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<JewelOperationResponseDto> addNewJewel(@RequestBody JewelRequestDto jewelRequestDto) {
        return new ResponseEntity<>(jewelService.addJewel(jewelRequestDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<JewelResponseDto>> getAllJewels() {
        return ResponseEntity.ok().body(jewelService.getAllJewels());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<JewelOperationResponseDto> deleteJewel(@PathVariable Long id) {
        return ResponseEntity.ok().body(jewelService.setAsUnsellable(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<JewelOperationResponseDto> updateJewel(
            @PathVariable Long id,
            @RequestBody JewelRequestDto jewelRequestDto
    ) {
        return ResponseEntity.ok().body(jewelService.updateJewel(id, jewelRequestDto));
    }
}
