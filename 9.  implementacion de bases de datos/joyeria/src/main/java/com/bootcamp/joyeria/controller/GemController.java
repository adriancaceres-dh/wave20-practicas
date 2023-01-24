package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.GemDto;
import com.bootcamp.joyeria.service.IGemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GemController {
    @Autowired
    IGemService gemService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createGem(@RequestBody GemDto gemDto){
        return  new ResponseEntity<>(gemService.createGem(gemDto), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<GemDto>> getAllGem(){
        return new ResponseEntity<>(gemService.getAllGem(),HttpStatus.OK);
    }

    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteGem(@PathVariable Long id){
        return new ResponseEntity<>(gemService.deleteGem(id),HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id}")
    public ResponseEntity<?> upDateGem(@PathVariable Long id, @RequestBody GemDto gemDto){
        return new ResponseEntity<>(gemService.UpDate(id, gemDto),HttpStatus.OK);
    }

}
