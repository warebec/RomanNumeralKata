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
			for (int i = 1; i < given.length(); i++) {
			  int first = result;
			  int second = symbolsMap.get(given.charAt(i));
			  if (second > first) {
				  result += (second - first);
			  }
			}
		}
		return 0;
	}
}
