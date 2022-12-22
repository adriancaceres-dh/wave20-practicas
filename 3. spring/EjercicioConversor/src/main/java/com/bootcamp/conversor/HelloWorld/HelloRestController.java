package com.bootcamp.primerprueba.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/saludar/{persona}")
    public String sayHello(@PathVariable String persona){
        return "Hello " + persona;
    }
}
