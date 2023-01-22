package com.morse.codigoMorse;

import org.springframework.boot.SpringApplication;
import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.rolling.helper.PeriodicityType;

@RestController
@RequestMapping("/api")
public class MorseController {
	@GetMapping("/morsetranslate")
	public String morseTranslate(@RequestParam String text) {
		// primero vamos a crear un mapa con todas las claves morse y su traducción a
		// español.
		// Nota: pendiente de revisión, hay claves que no están correctas...
		Map<String, String> diccionarioMorse = new HashMap<>();
		diccionarioMorse.put(".-", "a");
		diccionarioMorse.put("-...", "b");
		diccionarioMorse.put("-.-.", "c");
		diccionarioMorse.put("-..", "d");
		diccionarioMorse.put(".", "e");
		diccionarioMorse.put("..-.", "f");
		diccionarioMorse.put("--.", "g");
		diccionarioMorse.put("....", "h");
		diccionarioMorse.put("..", "i");
		diccionarioMorse.put(".---", "j");
		diccionarioMorse.put("-.-", "k");
		diccionarioMorse.put(".-..", "l");
		diccionarioMorse.put("--", "m");
		diccionarioMorse.put("--.--", "n");
		diccionarioMorse.put("---", "o");
		diccionarioMorse.put(".--.", "p");
		diccionarioMorse.put("--.-", "q");
		diccionarioMorse.put("-.-", "r");
		diccionarioMorse.put("...", "s");
		diccionarioMorse.put("-", "t");
		diccionarioMorse.put("..-", "u");
		diccionarioMorse.put("...-", "v");
		diccionarioMorse.put(".--", "w");
		diccionarioMorse.put("-..-", "x");
		diccionarioMorse.put("-.--", "y");
		diccionarioMorse.put("--..", "z");
		diccionarioMorse.put(".----", "1");
		diccionarioMorse.put("..---", "2");
		diccionarioMorse.put("...--", "3");
		diccionarioMorse.put("....-", "4");
		diccionarioMorse.put(".....", "5");
		diccionarioMorse.put("-....", "6");
		diccionarioMorse.put("--...", "7");
		diccionarioMorse.put("---..", "8");
		diccionarioMorse.put("----.", "9");
		diccionarioMorse.put("-----", "0");
		diccionarioMorse.put("..--..", "?");
		String[] palabras = text.split("   ");
		String textoTraducido = "";

		List<String> resultados = new ArrayList<>();
		if (palabras.length < 1) {
			// esto es en caso de que solo haya una palabra y no exista el split.
			palabras = new String[1];
			palabras[0] = text;
		}
		for (String palabra : palabras) {
			String[] caracteres = palabra.split(" ");
			Arrays.stream(caracteres).filter(w -> diccionarioMorse.containsKey(w))
					.forEach(z -> resultados.add(diccionarioMorse.get(z) + " "));
		}
		for (String resultado : resultados) {
			textoTraducido = textoTraducido + resultado;
		}

		return textoTraducido;

	}
}
