package com.bootcamp.codigomorse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodigomorseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodigomorseApplication.class, args);
		Codigomorse persona1 = new Codigomorse();
		System.out.println(persona1.asciiAMorse(".-"));
		System.out.println("aaaaa");
	}

	/*
	String[] words = morseCode.split("   ");
    if (words.length == 0) {
		return "";
	}
	StringBuilder stringBuffer = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
		String word = words[i];
		if (word.isEmpty())
			continue;
		String[] characters = word.split(" ");
		for (String character : characters) {
			stringBuffer.append(decodeLetter(character));
		}
		if (i != words.length - 1)
			stringBuffer.append(" ");
	}

	return stringBuffer.toString();


	 */

}
