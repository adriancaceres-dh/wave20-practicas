package com.example.SPRING_1.Controller;

import com.example.SPRING_1.Models.MorseCodeReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @GetMapping("/{morseCode}")
    public String translateMorseCode(@PathVariable String morseCode) {
        return MorseCodeReader.translate(morseCode);
    }
}
