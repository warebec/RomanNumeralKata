package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArabicNumeralConverter {

	static Map<Integer, String> symbolsMap = new HashMap<>();

	static {
		symbolsMap.put(1, "I");
		symbolsMap.put(5, "V");
		symbolsMap.put(10, "X");
		symbolsMap.put(50, "L");
		symbolsMap.put(100, "C");
		symbolsMap.put(500, "D");
		symbolsMap.put(1000, "M");
		symbolsMap.put(5000, "V̄");
		symbolsMap.put(10000, "X̄");
		symbolsMap.put(50000, "L̄");
		symbolsMap.put(100000, "C̄");
		symbolsMap.put(500000, "D̄");
		symbolsMap.put(1000000, "M̄");
	}

	public String convert(int given) {
		String givenStr = String.valueOf(given);
		List<Integer> intList = new ArrayList<>();
		for (int i = givenStr.length() - 1; i >= 0; i--) {
			intList.add(Integer.valueOf(givenStr.substring(i, i+1)));
		}

		String returnVal = "";
		for (int j = 0; j < intList.size(); j++) {
			if (intList.get(j) != 0) {
				returnVal = findSymbols(intList.get(j), j) + returnVal;
			}
		}

		return returnVal;
	}

	private String findSymbols(int value, int place) {
		boolean valIs4Or9 = value == 4 || value == 9;

		int subtractBy = 1;
		if (place > 0) {
			for (int i = 1; i <= place; i++) {
				value = value * 10;
				subtractBy = subtractBy * 10;
			}
		}

		if (valIs4Or9) {
			return symbolsMap.get(subtractBy) + symbolsMap.get(value + subtractBy);
		}

		String val = symbolsMap.get(value);
		int numSubtractions = 0;
		while (val == null && value > 0) {
			value = value - subtractBy;
			numSubtractions++;
			val = symbolsMap.get(value);
		}

		String returnVal = val;
		if (numSubtractions > 0) {
			String append = symbolsMap.get(subtractBy);
			for (int j = 1; j <= numSubtractions; j++) {
				returnVal = returnVal + append;
			}
		}
		return returnVal;
	}

}
