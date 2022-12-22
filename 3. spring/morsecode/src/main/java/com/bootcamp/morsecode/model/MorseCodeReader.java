package com.bootcamp.morsecode.model;

import java.util.HashMap;

public class MorseCodeReader {
    private static final HashMap<String, Character> dictionary = new HashMap<>();

    static {
        dictionary.put(".-", 'A');
        dictionary.put("-...", 'B');
        dictionary.put("-.-.", 'C');
        dictionary.put("-..", 'D');
        dictionary.put(".", 'E');
        dictionary.put("..-.", 'F');
        dictionary.put("--.", 'G');
        dictionary.put("....", 'H');
        dictionary.put("..", 'I');
        dictionary.put(".---", 'J');
        dictionary.put("-.-", 'K');
        dictionary.put(".-..", 'L');
        dictionary.put("--", 'M');
        dictionary.put("-.", 'N');
        dictionary.put("---", 'O');
        dictionary.put(".--.", 'P');
        dictionary.put("--.-", 'Q');
        dictionary.put(".-.", 'R');
        dictionary.put("...", 'S');
        dictionary.put("-", 'T');
        dictionary.put("..-", 'U');
        dictionary.put("...-", 'V');
        dictionary.put(".--", 'W');
        dictionary.put("-.--", 'Y');
        dictionary.put("-..-", 'X');
        dictionary.put("--..", 'Z');
        dictionary.put(".----", '1');
        dictionary.put("..---", '2');
        dictionary.put("....-", '4');
        dictionary.put(".....", '5');
        dictionary.put("-....", '6');
        dictionary.put("--...", '7');
        dictionary.put("---..", '8');
        dictionary.put("----", '9');
        dictionary.put("..--..", '?');
        dictionary.put("-.-.--", '!');
        dictionary.put(".-.-.-", '.');
        dictionary.put("--..--", ',');
    }

    public static String translate(String morseCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : morseCode.split("   ")) {
            for (String morseCharacter : word.split(" ")){
                stringBuilder.append(dictionary.get(morseCharacter));
            }
            stringBuilder.append(' ');
        }

        return stringBuilder.toString().stripTrailing();
    }
}
