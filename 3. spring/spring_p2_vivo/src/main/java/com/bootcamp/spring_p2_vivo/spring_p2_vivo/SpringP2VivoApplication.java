package com.bootcamp.spring_p2_vivo.spring_p2_vivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringP2VivoApplication {


	public static Map<String, String>getHashMap(){
		Map<String, String> morseMap = new HashMap<>();
		morseMap.put(".-","A" );
		morseMap.put("-...","B");
		morseMap.put("-.-.","C");
		morseMap.put("-..","D");
		morseMap.put(".","E" );
		morseMap.put("..-.", "F" );
		morseMap.put("--.","G" );
		morseMap.put("....", "H");
		morseMap.put("..","I" );
		morseMap.put(".---","J" );
		morseMap.put("-.-", "K" );
		morseMap.put(".-..","L" );
		morseMap.put("--","M");
		morseMap.put("-.","N" );
		morseMap.put("---","O" );
		morseMap.put(".--.","P");
		morseMap.put("--.-","Q");
		morseMap.put(".-.","R");
		morseMap.put("...","S");
		morseMap.put("-","T");
		morseMap.put("..-","U");
		morseMap.put("...-","V");
		morseMap.put(".--","W");
		morseMap.put("-..-","X");
		morseMap.put("-.--","Y");
		morseMap.put("--..","Z");
		morseMap.put(".----","1");
		morseMap.put("..---","2");
		morseMap.put("...--","3");
		morseMap.put("....-","4");
		morseMap.put(".....","5");
		morseMap.put("-....","6");
		morseMap.put("--...","7");
		morseMap.put("---..","8");
		morseMap.put("----.","9");
		morseMap.put("-----","0");
		morseMap.put("..--..","?");
		morseMap.put("-.-.--","!");
		morseMap.put(".-.-.-",".");
		morseMap.put("--..--",",");

		return morseMap;
	}
	@GetMapping ("/{word}")
	public  String hola(@PathVariable String word){
		Map<Character, String> morseMap = new HashMap<>();
		return decodedWord(word);
	}

	public static String decodedWord(String word){
		 String finalWord = "";
		 String[] letters = word.split(" ");
		 for (String letter : letters){
			 finalWord += getLetter(letter);
		 }
		 return finalWord;
	}

	public static String getLetter(String letter){
		Map<String, String> morseMap = getHashMap();
		return morseMap.get(letter);
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringP2VivoApplication.class, args);
	}


}
