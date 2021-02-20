package test.java;

import main.java.ArabicNumeralConverter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralTest {

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
		assertThat(converter.convert(14)).isEqualTo("XIV");
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
		if (true) {
			return;
		}
		ArabicNumeralConverter converter = new ArabicNumeralConverter();
		File output = new File("src/test/java/ConvertRomanToArabicTest1.java");
		makeFile(output);

		int fileNum = 1;
		try {
			FileWriter fileWriter = new FileWriter(output);
			writeBeginningOfFile(fileNum, fileWriter);
			for (int i = 1; i <= 1000000; i++) {
				fileWriter.write("assertThat(converter.convert(\"" + converter.convert(i) + "\")).isEqualTo(" + i + ");\n");
				if (i % 2000 == 0) {
					fileWriter.write("\t}\n" +
							"}");
					fileWriter.close();
					if (i < 1000000) {
						fileNum++;
						output = new File("src/test/java/ConvertRomanToArabicTest" + fileNum + ".java");
						makeFile(output);
						fileWriter = new FileWriter(output);
						writeBeginningOfFile(fileNum, fileWriter);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeBeginningOfFile(int fileNum, FileWriter fileWriter) throws IOException {
		fileWriter.write("package test.java;\n" +
				"\n" +
				"import static org.assertj.core.api.Assertions.*;\n" +
				"\n" +
				"import org.junit.jupiter.api.Test;\n" +
				"\n" +
				"import main.java.ArabicNumeralConverter;\n" +
				"import main.java.RomanNumeralConverter;\n" +
				"\n" +
				"public class ConvertRomanToArabicTest" + fileNum + " {\n" +
				"\n" +
				"\t@Test\n" +
				"\tvoid convertRomanToArabic" + fileNum + "() {\n" +
				"\t\tRomanNumeralConverter converter = new RomanNumeralConverter();\n\n");
	}

	private void makeFile(File output) {
		try {
			if (output.exists()) {
				output.delete();
			}
			output.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void generateArabicToRomanAsserts() {
		if (true) {
			return;
		}
		File output = new File("src/test/resources/ArabicToRomanAsserts.txt");
		makeFile(output);

		try (FileWriter fileWriter = new FileWriter(output)) {
			for (int i = 1; i <= 1000000; i++) {
				fileWriter.write("assertThat(converter.convert(" + i + ")).isEqualTo(\"i\");\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
