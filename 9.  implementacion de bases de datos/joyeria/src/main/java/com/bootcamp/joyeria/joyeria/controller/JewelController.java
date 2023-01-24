package com.bootcamp.joyeria.joyeria.controller;

import com.bootcamp.joyeria.joyeria.dot.JewelDTO;
import com.bootcamp.joyeria.joyeria.dot.MessageDTO;
import com.bootcamp.joyeria.joyeria.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {
    @Autowired
    private IJewelService jewelService;

    @GetMapping("/")
    public ResponseEntity<List<JewelDTO>>  getJewelry(){
        return ResponseEntity.ok(jewelService.getAllJewels());
    }

    @PostMapping("/new")
    public ResponseEntity<JewelDTO> newJewel(@RequestBody(required = false) JewelDTO newJewel){
        return ResponseEntity.ok(jewelService.saveJewel(newJewel));
    }

    @PostMapping("/update/{id_modificar}")
    public ResponseEntity<JewelDTO> modifyJewel(@RequestBody JewelDTO modifiedJewel, @PathVariable Long id_modificar){
        modifiedJewel.setIdNum(id_modificar);
        return ResponseEntity.ok(jewelService.saveJewel(modifiedJewel));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJewel(@PathVariable Long id){
        return ResponseEntity.ok(jewelService.deleteJewel(id));
    }
}
