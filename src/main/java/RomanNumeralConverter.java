package main.java;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    static Map<String, Integer> symbolsMap = new HashMap<>();

    static {
        symbolsMap.put("I", 1);
        symbolsMap.put("V", 5);
        symbolsMap.put("X", 10);
        symbolsMap.put("L", 50);
        symbolsMap.put("C", 100);
        symbolsMap.put("D", 500);
        symbolsMap.put("M", 1000);
        symbolsMap.put("V̄", 5000);
    }

    public int convert(String given) {
        String symbolKey = findNextSymbolKey(given, 0);
        int result = symbolsMap.get(symbolKey);
        if (given.length() > 1) {
            symbolKey = findNextSymbolKey(given, 1);
            int second = symbolsMap.get(symbolKey);
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

    private String findNextSymbolKey(String given, int startIndex) {
        System.out.println("String given: " + given);
        if (given.length() > startIndex+2 && "̄".equals(given.substring(startIndex+1, startIndex+2))) {
            return given.substring(startIndex, startIndex+2);
        } else {
            return given.substring(startIndex, startIndex+1);
        }
    }
}
