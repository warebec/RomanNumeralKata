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
        symbolsMap.put("X̄", 10000);
        symbolsMap.put("L̄", 50000);
        symbolsMap.put("C̄", 100000);
        symbolsMap.put("D̄", 500000);
        symbolsMap.put("M̄", 1000000);
    }

    public int convert(String given) {
        String symbolKey = findNextSymbolKey(given, 0);
        int result = symbolsMap.get(symbolKey);
        if (given.length() > symbolKey.length()) {
            String symbolKey1 = findNextSymbolKey(given, symbolKey.length());
            int second = symbolsMap.get(symbolKey1);
            if (second > result) {
                result = second - result;
                int usedLength = symbolKey.length() + symbolKey1.length();
                if (given.length() > usedLength) {
                    result += convert(given.substring(usedLength));
                }
            } else {
                result += convert(given.substring(symbolKey.length()));
            }
        }
        return result;
    }

    private String findNextSymbolKey(String given, int startIndex) {
        if (given.length() < startIndex+2) {
            return given.substring(startIndex, startIndex+1);
        }

        String potentialKey = given.substring(startIndex, startIndex+2);
        if (!symbolsMap.containsKey(potentialKey)) {
            potentialKey = given.substring(startIndex, startIndex+1);
        }
        return potentialKey;
    }
}
