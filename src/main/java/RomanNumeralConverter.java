package main.java;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    static Map<Character, Integer> symbolsMap = new HashMap<>();

    static {
        symbolsMap.put('I', 1);
        symbolsMap.put('V', 5);
        symbolsMap.put('X', 10);
        symbolsMap.put('L', 50);
        symbolsMap.put('C', 100);
    }

    public int convert(String given) {
        int result = symbolsMap.get(given.charAt(0));
        if (given.length() > 1) {
            int second = symbolsMap.get(given.charAt(1));
            if (second > result) {
                result = second - result;
                if (given.length() > 2) {
                    result += convert(given.substring(2));
                }
            } else {
                result += convert(given.substring(1));
            }
        }
        return result;
    }
}
