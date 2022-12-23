package com.bootcamp.dto_responseentity.p2.pg.dto_responseentity.controller;

import com.bootcamp.dto_responseentity.p2.pg.dto_responseentity.dto.request.RequestDto;
import com.bootcamp.dto_responseentity.p2.pg.dto_responseentity.dto.request.Persona;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public RequestDto requestDto = new RequestDto(new Persona(1,10,"luciano","benavdis"));
    @GetMapping("/")
    public String saludo(){
        return "llegue";
    }
}
