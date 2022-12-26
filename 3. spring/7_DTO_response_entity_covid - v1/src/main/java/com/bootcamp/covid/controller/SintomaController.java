package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.response.SintomaResponseDto;
import com.bootcamp.covid.service.ISintomaService;
import com.bootcamp.covid.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SintomaController {

    @Autowired
    private ISintomaService sintomaService;
    /*
    public SintomaController() {
        sintomaService = new SintomaService();
    }
    */
    @GetMapping("/findsympton")
    public ResponseEntity<List<SintomaResponseDto>> findSympton() {
        return new ResponseEntity<>(sintomaService.findSympton(), HttpStatus.OK);
    }

    @GetMapping("/findsympton/{name}")
    public ResponseEntity<SintomaResponseDto> findSympton(@PathVariable String name) {
        return new ResponseEntity<>(sintomaService.findSympton(name), HttpStatus.OK);
    }

}
