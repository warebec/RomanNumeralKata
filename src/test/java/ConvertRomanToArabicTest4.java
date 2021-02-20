package test.java;

import main.java.RomanNumeralConverter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertRomanToArabicTest4 {

    @Test
    void convertRomanToArabic4() {
        RomanNumeralConverter converter = new RomanNumeralConverter();

        assertThat(converter.convert("MX̄")).isEqualTo(9000);
        assertThat(converter.convert("X̄")).isEqualTo(10000);
        assertThat(converter.convert("X̄L̄")).isEqualTo(40000);
        assertThat(converter.convert("L̄")).isEqualTo(50000);
        assertThat(converter.convert("X̄C̄")).isEqualTo(90000);
        assertThat(converter.convert("C̄")).isEqualTo(100000);
        assertThat(converter.convert("C̄D̄")).isEqualTo(400000);
        assertThat(converter.convert("D̄")).isEqualTo(500000);
        assertThat(converter.convert("C̄M̄")).isEqualTo(900000);
        assertThat(converter.convert("M̄")).isEqualTo(1000000);
    }
}