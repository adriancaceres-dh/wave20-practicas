package com.spring.lasperlas.controller;

import com.spring.lasperlas.dto.MessageDTO;
import com.spring.lasperlas.dto.request.JewelRequestDTO;
import com.spring.lasperlas.dto.response.JewelListedDTO;
import com.spring.lasperlas.service.IJewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    private IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createJewel(@RequestBody JewelRequestDTO jewelRequestDTO){
        return new ResponseEntity<MessageDTO>(jewelService.createJewel(jewelRequestDTO), HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<JewelListedDTO> getJewerly(){
        return new ResponseEntity<>(jewelService.getJewerly(), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(jewelService.deleteJewelLogically(id), HttpStatus.OK);
    }
}
