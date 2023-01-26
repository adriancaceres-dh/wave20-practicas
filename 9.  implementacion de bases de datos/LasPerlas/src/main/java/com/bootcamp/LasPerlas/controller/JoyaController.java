package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.dto.request.CompleteJoyaRequestDTO;
import com.bootcamp.LasPerlas.dto.request.JoyaRequestDto;
import com.bootcamp.LasPerlas.dto.response.JoyaResponseDto;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {
    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<String> createNewJoya (@RequestBody JoyaRequestDto newJoya){
        Long id = this.joyaService.saveJoya(newJoya);
        return new ResponseEntity("nro identificatorio: "+id, HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaResponseDto>> getAllJoyas (){
        List<JoyaResponseDto> joyas = this.joyaService.getJoyas();
        return new ResponseEntity<>(joyas,HttpStatus.OK);
    }

    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> disableJoya(@PathVariable("id") long id){
        this.joyaService.disableJoya(id);
        return new ResponseEntity<>("Joya inhabilidata con éxito",HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<JoyaResponseDto> updateJoya(@PathVariable("id_modificar") Long id,
                                                      @RequestBody JoyaRequestDto joya){
        JoyaResponseDto editedJoya= this.joyaService.editJoya(id,joya);
        return new ResponseEntity<>(editedJoya,HttpStatus.OK);
    }
}
