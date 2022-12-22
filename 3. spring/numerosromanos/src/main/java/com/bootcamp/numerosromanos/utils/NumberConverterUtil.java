package com.bootcamp.numerosromanos.utils;

import java.util.Map;

import static java.util.Map.entry;

public class NumberConverterUtil {
    static private final Map<Character, Integer> romanianMap = Map.ofEntries(
            entry('I', 1),
            entry('V', 5),
            entry('X', 10),
            entry('L', 50),
            entry('C', 100),
            entry('D', 500),
            entry('M', 1000)
    );

    public static Integer transformRomanianToInteger(String romanian) {
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

}
