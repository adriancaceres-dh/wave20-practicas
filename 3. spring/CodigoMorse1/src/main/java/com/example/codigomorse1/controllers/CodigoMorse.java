package com.example.codigomorse1.controllers;

import com.example.codigomorse1.utils.CodigoMorseKeyValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.stream.Stream;

@RestController()
@RequestMapping("/Traducir")
public class CodigoMorse {

    @GetMapping("/AAscii")
    public String traducirMorse(@RequestParam (value = "texto", required = true)String Texto) {
        String[] textoArr = Texto.split(" ");
        StringBuilder builder = new StringBuilder();
        Arrays.stream(textoArr).forEach(morse -> { builder.append(CodigoMorseKeyValue.getMorseAsKey(morse));});
        return builder.toString();
    }
}
