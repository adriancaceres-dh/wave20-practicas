package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;
}
