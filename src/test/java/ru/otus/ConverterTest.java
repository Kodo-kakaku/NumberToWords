package ru.otus;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.currency.Currency;
import ru.otus.enums.CurrencyNames;
import ru.otus.factory.CurrencyFactory;
import ru.otus.service.Converter;

import java.util.stream.LongStream;

public class ConverterTest {
    private Currency currencyRubles;
    @BeforeEach
    @DisplayName("Проверяем, на ввод нуля")
    public void init() {
        this.currencyRubles = new CurrencyFactory().createCurrency(CurrencyNames.RUBLES);
    }

    @Test
    @DisplayName("Проверяем, на ввод нуля")
    void zeroTest() {
        long number = 0;
        String expected = "ноль рублей";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на ввод единицы")
    void oneTest() {
        long number = 1;
        String expected = "один рубль";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на ввод значений до 4")
    void upToFourTest() {
        long[] number = {2, 3, 4};
        String[] expected = {"два", "три", "четыре"};
        for(int i = 0; i < number.length; i++) {
            Converter converter = new Converter(number[i], currencyRubles);
            Assertions.assertEquals(expected[i] + " рубля", converter.convert());
        }
    }
    @Test
    @DisplayName("Проверяем, на ввод значений до 20")
    void upToTwentyTest() {
        long[] number = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        String[] expected = {"пять", "шесть", "семь", "восемь", "девять", "десять", "одинадцать",
                "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};
        for(int i = 0; i < number.length; i++) {
            Converter converter = new Converter(number[i], currencyRubles);
            Assertions.assertEquals(expected[i] + " рублей", converter.convert());
        }
    }

    @Test
    @DisplayName("Проверяем, на ввод значений до 100")
    void upToHundredsTest() {
        long[] numbers = LongStream.rangeClosed(20, 99).toArray();
        String[] expectedDigits = {"", " один", " два", " три", " четыре",
                " пять", " шесть", " семь", " восемь", " девять"};
        String[] expectedDozens = {"двадцать", "тридцать", "сорок", "пятьдесят",
                "шестьдесят", "семьдесят", "восемьдесят", "девяносто" };

        int iter = 0;
        for (String expectedDozen : expectedDozens) {
            for (String expectedDigit : expectedDigits) {
                String rubles;
                switch (iter % 10) {
                    case 1 -> rubles = " рубль";
                    case 2,3,4 -> rubles = " рубля";
                    default -> rubles = " рублей";
                }

                Converter converter = new Converter(numbers[iter], currencyRubles);
                Assertions.assertEquals(expectedDozen + expectedDigit + rubles, converter.convert());
                iter += 1;
            }
        }
    }

    @Test
    @DisplayName("Проверяем, на тысячу")
    void thousandTest() {
        long number = 1000;
        String expected = "одна тысяча рублей";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на одну тысячу двести пятьдесят три")
    void thousand253Test() {
        long number = 1253;
        String expected = "одна тысяча двести пятьдесят три рубля";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на четыре тысячи пятьсот тридцать")
    void fourThousand530Test() {
        long number = 4530;
        String expected = "четыре тысячи пятьсот тридцать рублей";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на сто десять тысяч")
    void hundred10Test() {
        long number = 110000;
        String expected = "сто десять тысяч рублей";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на один миллион три")
    void million3Test() {
        long number = 1003000;
        String expected = "один миллион три тысячи рублей";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на пятьдесят четыре миллиона пятьсот шестьдесят восемь тысяч четыреста восемьдесят один")
    void masculine54568481Test() {
        long number = 54568481;
        String expected = "пятьдесят четыре миллиона пятьсот шестьдесят восемь тысяч четыреста восемьдесят один рубль";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на ввод минус единицы")
    void minusOneTest() {
        long number = -1;
        String expected = "минус один рубль";
        Converter converter = new Converter(number, currencyRubles);
        Assertions.assertEquals(expected, converter.convert());
    }

    @Test
    @DisplayName("Проверяем, на ввод значений до минус 4")
    void minusUpToFourTest() {
        long[] number = {-2, -3, -4};
        String[] expected = {"два", "три", "четыре"};
        for(int i = 0; i < number.length; i++) {
            Converter converter = new Converter(number[i], currencyRubles);
            Assertions.assertEquals("минус " + expected[i] + " рубля", converter.convert());
        }
    }
    @Test
    @DisplayName("Проверяем, на ввод значений до минус 20")
    void minusUpToTwentyTest() {
        long[] number = {-5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19, -20};
        String[] expected = {"пять", "шесть", "семь", "восемь", "девять", "десять", "одинадцать",
                "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};
        for(int i = 0; i < number.length; i++) {
            Converter converter = new Converter(number[i], currencyRubles);
            Assertions.assertEquals("минус " + expected[i] + " рублей", converter.convert());
        }
    }

    @Test
    @DisplayName("Проверяем, на ввод значений до минус 100")
    void minusUpToHundredsTest() {
        long[] numbers = LongStream.rangeClosed(-99, -20).toArray();

        String[] expectedDigits = {"", " один", " два", " три", " четыре",
                " пять", " шесть", " семь", " восемь", " девять"};
        String[] expectedDozens = {"двадцать", "тридцать", "сорок", "пятьдесят",
                "шестьдесят", "семьдесят", "восемьдесят", "девяносто" };

        int iter = numbers.length - 1;
        for (String expectedDozen : expectedDozens) {
            for (String expectedDigit : expectedDigits) {
                String rubles;
                switch (iter % 10) {
                    case 8 -> rubles = " рубль";
                    case 7,6,5 -> rubles = " рубля";
                    default -> rubles = " рублей";
                }

                Converter converter = new Converter(numbers[iter], currencyRubles);
                Assertions.assertEquals("минус " + expectedDozen + expectedDigit + rubles, converter.convert());
                iter -= 1;
            }
        }
    }
}