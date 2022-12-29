package com.ej2_spring.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;
@RestController
public class MorseController {

    @GetMapping("/morseATexto/{texto}")
    public String morseATexto(@PathVariable String texto) {
        Map<String, String> morseCodeMap = Map.ofEntries(
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

        String[] textoSinEspacios = texto
                .replaceAll("   "," X ")
                .split(" ");

        return Arrays.stream(textoSinEspacios)
                .map(morseCodeMap::get)
                .collect(Collectors.joining());
    }
}