package com.bootcamp.codigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    static Map<String,String> morseDictionary = new HashMap<>(){
         {
             put(".-","A");
             put("-...","B");
             put("-.-.","C");
             put("-..","D");
             put(".","E");
             put("..-.","F");
             put("--.","G");
             put("....","H");
             put("..","I");
             put(".---","J");
             put("-.-","K");
             put(".-..","L");
             put("--","M");
             put("-.","N");
             put("---","O");
             put(".--.","P");
             put("--.-","Q");
             put(".-.","R");
             put("...","S");
             put("-","T");
             put("..-","U");
             put("...-","V");
             put(".--","W");
             put("-..-","X");
             put("-.--","Y");
             put("--..","Z");
             put("-----","0");
             put(".----","1");
             put("..---","2");
             put("...--","3");
             put("....-","4");
             put(".....","5");
             put("-....","6");
             put("--...","7");
             put("---..","8");
             put("----.","9");
             put("..--..","?");
             put("-.-.--","!");
             put(".-.-.-",".");
             put("--..--",",");
         }};

    @GetMapping("/{morseMessage}")
    public String decodeMorseMessage(@PathVariable String morseMessage){

        char letterSeparator = ' ';
        String wordSeparator = "   ";
        StringBuilder decodedMessageBuilder = new StringBuilder();
        StringBuilder morseSymbolToTranslateBuilder = new StringBuilder();

        // O(N) complexity
        int currentIndex = 0;

        while ( currentIndex < morseMessage.length()){
            char currentCharacter = morseMessage.charAt(currentIndex);

            if (currentCharacter != letterSeparator){
                morseSymbolToTranslateBuilder.append(morseMessage.charAt(currentIndex));
            }
            else {
                decodedMessageBuilder.append(morseDictionary.get(morseSymbolToTranslateBuilder.toString()));
                morseSymbolToTranslateBuilder.setLength(0); // clear builder efficiently
            }

            if (currentIndex == morseMessage.length() -1){
                decodedMessageBuilder.append(morseDictionary.get(morseSymbolToTranslateBuilder.toString()));
            }

            if (morseMessage.startsWith(wordSeparator,currentIndex)){
                decodedMessageBuilder.append(" ");
                currentIndex += wordSeparator.length(); //move pointer to skip word-separator Length
            } else currentIndex++;
        }

        return (decodedMessageBuilder.toString());
    }
}
