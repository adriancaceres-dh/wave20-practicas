package com.Springprofiles.P2Pgexample.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Value("${spring.message}")
    String message;

    @GetMapping("/mensaje")
    public String darMensaje()
    {
        return message;
    }
}
