package com.bootcamp.springp1integradorlinktracker.controller;

import com.bootcamp.springp1integradorlinktracker.dto.request.LinkRequestDTO;
import com.bootcamp.springp1integradorlinktracker.dto.response.LinkResponseDTO;
import com.bootcamp.springp1integradorlinktracker.service.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkTrackerController {
    @Autowired
    private LinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> crearLink(@RequestBody LinkRequestDTO link){
        return new ResponseEntity<>(linkTrackerService.add(link), HttpStatus.OK);
    }

    @GetMapping("/ping")
    public String ping(){
        return "hola";
    }
}
