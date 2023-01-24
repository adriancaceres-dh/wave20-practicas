package com.example.crud_joyeria.controller;

import com.example.crud_joyeria.dto.JoyaDto;
import com.example.crud_joyeria.dto.MessageDto;
import com.example.crud_joyeria.dto.request.JoyaCreateDto;
import com.example.crud_joyeria.service.IJoyaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<MessageDto> create(@RequestBody JoyaCreateDto joyaCreateDto){

        return new ResponseEntity(joyaService.create(joyaCreateDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDto>> list(){

        return new ResponseEntity<>(joyaService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> list(@PathVariable Long id){

        return new ResponseEntity<>(joyaService.logicDelete(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaDto> modify(
            @PathVariable(name = "id_modificar") Long id,
            @RequestBody JoyaDto joyaDto)
    {

        return new ResponseEntity<>(joyaService.modify(joyaDto,id), HttpStatus.OK);
    }

    
}
