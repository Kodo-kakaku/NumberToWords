package ru.otus;

import ru.otus.currency.Currency;
import ru.otus.enums.CurrencyNames;
import ru.otus.factory.CurrencyFactory;
import ru.otus.service.Converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextLong()) {
            System.out.println("popo");
            Currency currencyRubles = new CurrencyFactory().getCurrency(CurrencyNames.RUBLES);
            Converter converter = new Converter(scanner.nextLong(), currencyRubles);
            String convertNumToWordResult = converter.Convert();
            System.out.println("Answer: " + convertNumToWordResult);
        } else {
            // вывести что нужно вводить только числа и после этого завершить работу
            System.out.println("Для ввода нужно использовать цифры." +
                    " При вводе дробного цисла разделителем служит символ -> '.'");
        }
        scanner.close();
    }
}