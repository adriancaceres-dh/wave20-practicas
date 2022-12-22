package com.bootcamp.morse.controllers;

import com.bootcamp.morse.utils.MorseCodeTranslatorUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseCodeController {

    @GetMapping("/{morseCode}")
    public String getWordFromMorseCode(@PathVariable String morseCode) {
        return MorseCodeTranslatorUtil.transformMorseCodeToLetters(morseCode);
    }
}
