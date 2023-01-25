package com.joyeria.joyeria.controller;

import com.joyeria.joyeria.dto.JewelRequestDto;
import com.joyeria.joyeria.dto.JewelResponseDto;
import com.joyeria.joyeria.dto.JewelryListResponseDto;
import com.joyeria.joyeria.dto.MessageDto;
import com.joyeria.joyeria.service.IJewelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/jewelry")
public class JewelController {

    IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<JewelResponseDto> createJewel(@RequestBody @Valid JewelRequestDto jewelDto){
        return ResponseEntity.ok(jewelService.createJewel(jewelDto));
    }

    @GetMapping()
    public ResponseEntity<JewelryListResponseDto> getAllJewelry(){
        return ResponseEntity.ok(jewelService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> deleteJewel(@PathVariable Integer id){
        return ResponseEntity.ok(jewelService.delete(id));
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JewelResponseDto> updateJewel(@RequestBody @Valid JewelRequestDto jewelDto){
        return ResponseEntity.ok(jewelService.updateJewel(jewelDto));
    }
}
