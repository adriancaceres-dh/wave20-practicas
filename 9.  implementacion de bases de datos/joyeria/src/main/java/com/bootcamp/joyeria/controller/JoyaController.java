package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.common.JoyaDTO;
import com.bootcamp.joyeria.dto.request.CreateJoyaDTO;
import com.bootcamp.joyeria.dto.response.MessageDTO;
import com.bootcamp.joyeria.dto.response.UpdatedJoyaDTO;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createJoya(@RequestBody CreateJoyaDTO createJoyaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(joyaService.createJoya(createJoyaDTO));
    }

    @GetMapping
    public ResponseEntity<List<JoyaDTO>> getJoyas() {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.getJoyas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaDTO> getJoyaById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.getJoyaById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdatedJoyaDTO> updateJoya(@PathVariable Long id, @RequestBody CreateJoyaDTO joyaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.updateJoya(id, joyaDTO));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJoyaById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.deleteJoyaById(id));
    }
}
