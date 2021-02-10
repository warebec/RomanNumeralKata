package test.java;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;

import org.junit.jupiter.api.Test;

import main.java.ArabicNumeralConverter;
import main.java.RomanNumeralConverter;

public class RomanNumeralTest {

	@Test
	void convertRomanToArabic() {
		RomanNumeralConverter converter = new RomanNumeralConverter();
		
		assertThat(converter.convert("i")).isEqualTo(1);
		assertThat(converter.convert("ii")).isEqualTo(2);
		assertThat(converter.convert("iii")).isEqualTo(3);
		assertThat(converter.convert("iv")).isEqualTo(4);
		assertThat(converter.convert("v")).isEqualTo(5);
		assertThat(converter.convert("vi")).isEqualTo(6);
		assertThat(converter.convert("vii")).isEqualTo(7);
		assertThat(converter.convert("viii")).isEqualTo(8);
		assertThat(converter.convert("ix")).isEqualTo(9);
		assertThat(converter.convert("x")).isEqualTo(10);
	}
	
	@Test
	void convertArabicToRoman() {
		ArabicNumeralConverter converter = new ArabicNumeralConverter();
		
		assertThat(converter.convert(1)).isEqualTo("I");
		assertThat(converter.convert(2)).isEqualTo("II");
		assertThat(converter.convert(3)).isEqualTo("III");
		assertThat(converter.convert(4)).isEqualTo("IV");
		assertThat(converter.convert(5)).isEqualTo("V");
		assertThat(converter.convert(6)).isEqualTo("VI");
		assertThat(converter.convert(7)).isEqualTo("VII");
		assertThat(converter.convert(8)).isEqualTo("VIII");
		assertThat(converter.convert(9)).isEqualTo("IX");
		assertThat(converter.convert(10)).isEqualTo("X");
		assertThat(converter.convert(40)).isEqualTo("XL");
		assertThat(converter.convert(50)).isEqualTo("L");
		assertThat(converter.convert(90)).isEqualTo("XC");
		assertThat(converter.convert(100)).isEqualTo("C");
		assertThat(converter.convert(400)).isEqualTo("CD");
		assertThat(converter.convert(500)).isEqualTo("D");
		assertThat(converter.convert(900)).isEqualTo("CM");
		assertThat(converter.convert(1000)).isEqualTo("M");
		assertThat(converter.convert(4000)).isEqualTo("MV̄");
		assertThat(converter.convert(5000)).isEqualTo("V̄");
		assertThat(converter.convert(9000)).isEqualTo("MX̄");
		assertThat(converter.convert(10000)).isEqualTo("X̄");
		assertThat(converter.convert(40000)).isEqualTo("X̄L̄");
		assertThat(converter.convert(50000)).isEqualTo("L̄");
		assertThat(converter.convert(90000)).isEqualTo("X̄C̄");
		assertThat(converter.convert(100000)).isEqualTo("C̄");
		assertThat(converter.convert(400000)).isEqualTo("C̄D̄");
		assertThat(converter.convert(500000)).isEqualTo("D̄");
		assertThat(converter.convert(900000)).isEqualTo("C̄M̄");
		assertThat(converter.convert(1000000)).isEqualTo("M̄");
	}
	
	@Test
	void generateRomanToArabicAsserts() {
		File output = new File("src/test/resources/RomanToArabicAsserts.txt");
		try {
			if (output.exists()) {
				output.delete();
			}
			output.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (FileWriter fileWriter = new FileWriter(output)) {
			for (int i = 1; i <= 1000000; i++) {
				fileWriter.write("assertThat(converter.convert(\"i\")).isEqualTo(" + i + ");\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void generateArabicToRomanAsserts() {
		File output = new File("src/test/resources/ArabicToRomanAsserts.txt");
		try {
			if (output.exists()) {
				output.delete();
			}
			output.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (FileWriter fileWriter = new FileWriter(output)) {
			for (int i = 1; i <= 1000000; i++) {
				fileWriter.write("assertThat(converter.convert(" + i + ")).isEqualTo(\"i\");\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
