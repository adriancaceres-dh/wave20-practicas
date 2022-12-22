package com.bootcamp.morsecode.controller;

import com.bootcamp.morsecode.model.MorseCodeReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseCodeController {

    @GetMapping("/{morseCode}")
    public String translateMorseCode(@PathVariable String morseCode) {
        return MorseCodeReader.translate(morseCode);
    }

}
