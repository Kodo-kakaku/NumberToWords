package ru.otus;

import ru.otus.currency.Currency;
import ru.otus.enums.CurrencyNames;
import ru.otus.factory.CurrencyFactory;
import ru.otus.service.Converter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long userInput = scanner.nextLong();
            Currency currencyRubles = new CurrencyFactory().createCurrency(CurrencyNames.RUBLES);
            Converter converter = new Converter(userInput, currencyRubles);
            String convertNumToWordResult = converter.convert();
            System.out.println(convertNumToWordResult);
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("""
                    Введите число до миллиона! Ввод осуществляется цифрами!
                    Пример:\s
                    Ввод: 1000000000\s
                    Вывод: один миллиард рублей""");
        }
    }
}