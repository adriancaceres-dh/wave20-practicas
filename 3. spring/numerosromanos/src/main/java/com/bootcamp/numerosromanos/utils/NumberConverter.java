package com.bootcamp.numerosromanos.utils;

import java.util.HashMap;
import java.util.Map;

public class NumberConverter {
    static private final Map<Character, Integer> romanianMap = new HashMap<>();

    public static Integer transformRomanianToInteger(String romanian) {
        fillRomanianMap();
        int arabic = 0;
        for (int i = 0; i < romanian.length(); i++) {
            char ch = romanian.charAt(i);
            if (i > 0 && romanianMap.get(ch) > romanianMap.get(romanian.charAt(i - 1))) {
                arabic += romanianMap.get(ch) - 2 * romanianMap.get(romanian.charAt(i - 1));
            } else
                arabic += romanianMap.get(ch);
        }
        return arabic;
    }

    private static void fillRomanianMap() {
        romanianMap.putIfAbsent('I', 1);
        romanianMap.putIfAbsent('V', 5);
        romanianMap.putIfAbsent('X', 10);
        romanianMap.putIfAbsent('L', 50);
        romanianMap.putIfAbsent('C', 100);
        romanianMap.putIfAbsent('D', 500);
        romanianMap.putIfAbsent('M', 1000);
    }

}
