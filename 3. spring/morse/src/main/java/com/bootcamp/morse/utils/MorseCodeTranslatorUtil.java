package com.bootcamp.morse.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class MorseCodeTranslatorUtil {
    private static final Map<String, String> morseCodeMap = Map.ofEntries(
            entry(".-", "A"),
            entry("-...", "B"),
            entry("-.-.", "C"),
            entry("-..", "D"),
            entry(".", "E"),
            entry("..-.", "F"),
            entry("--.", "G"),
            entry("....", "H"),
            entry("..", "I"),
            entry(".---", "J"),
            entry("-.-", "K"),
            entry(".-..", "L"),
            entry("--", "M"),
            entry("-.", "N"),
            entry("---", "O"),
            entry(".--.", "P"),
            entry("--.-", "Q"),
            entry(".-.", "R"),
            entry("...", "S"),
            entry("-", "T"),
            entry("..-", "U"),
            entry("...-", "V"),
            entry(".--", "W"),
            entry("-..-", "X"),
            entry("-.--", "Y"),
            entry("--..", "Z"),
            entry(".----", "1"),
            entry("..---", "2"),
            entry("...--", "3"),
            entry("....-", "4"),
            entry(".....", "5"),
            entry("-....", "6"),
            entry("--...", "7"),
            entry("---..", "8"),
            entry("----.", "9"),
            entry("-----", "0"),
            entry("..--..", "?"),
            entry(".-.-.-", "."),
            entry("-.-.--", "!"),
            entry("--..--", ","),
            entry(" ", "\0"),
            entry("X", " ")
    );

    public static String transformMorseCodeToLetters(String morseCode) {
        // marco el triple espacio de una con una X para poder matchear el mapa que definí
        String espacios = morseCode.replaceAll("   "," X ");
        String[] palabras = espacios.split(" ");
        return Arrays.stream(palabras)
                .map(morseCodeMap::get)
                .collect(Collectors.joining());
    }
}
