package com.wave20.java.controller;

import com.wave20.java.service.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @GetMapping("/{morse}")
    public String getMorse(@PathVariable String morse) {
        return MorseService.decodificarMorse(morse);
    }


}
