package ru.otus.service;

import ru.otus.currency.Currency;
import ru.otus.enums.NounCases;

import java.math.BigDecimal;

public class Converter {
    private final long THOUSAND = 1_000L;
    private final long MILLION = 1_000_000L;
    private final long MILLIARD = 1_000_000_000L;
    private final long TRILLION = 1_000_000_000_000L;

    private final long MAX_VALUE = TRILLION - 1;
    private StringBuilder result;
    private long userInput;
    private final Currency currency;

    public Converter(long userInput, Currency currency) {
        this.userInput = userInput;
        this.currency = currency;
    }

    // TODO Implementation of currency transfer in the method
    public String Convert() {
        result = new StringBuilder();

        if (userInput < 0) {
            result.append(currency.MINUS);
            userInput = -userInput;
        } else if (userInput == 0) {
            result.append(currency.ZERO);
        }

        if (userInput >= TRILLION) {
            System.out.println("EXCEPTION");
        }

        long value;
        if (userInput >= MILLIARD) {
            value = userInput / MILLIARD;
            AppendNumber((int)value, NounCases.MASCULINE); /// сужающие приведение типов!!!
            AppendUnitOfMeasure(value % 100);
            userInput %= MILLIARD;
        }

        if(userInput >= MILLION) {
            value = userInput / MILLION;
            AppendNumber((int)value, NounCases.MASCULINE);
            AppendUnitOfMeasure(value % 100);
            userInput %= MILLION;
        }

        if(userInput >= THOUSAND) {
            value = userInput / THOUSAND;
            AppendNumber((int) value, NounCases.FEMININE);
            AppendUnitOfMeasure(value % 100);
            userInput %= THOUSAND;
        }

        if (userInput > 0) {
            AppendNumber((int) userInput, NounCases.FEMININE);
        }
        AppendUnitOfMeasure(5);

      return result.toString();
    }

    private void AppendNumber(int value, NounCases noun) {
        //Debug.Assert(_result != null);
        //Debug.Assert(value > 0);
        //Debug.Assert(value < 1000);

        // Write hundreds

        if (value >= 100) {
            int index = value / 100;
            value = value % 100;
            this.result.append(' ');
            this.result.append(currency.HUNDREDS[index]);
        }

        // Write dozens

        if (value >= 20) {
            int index = value / 10;
            value = value % 10;
            this.result.append(' ');
            this.result.append(currency.DOZENS[index]);
        } else if (value >= 10) {
            int index = value - 10;
            this.result.append(' ');
            this.result.append(currency.DOZENS[index]);
            return;
        }

        // Write digit
        if (value > 0) {
            this.result.append(' ');
            this.result.append(currency.DIGITS[value][noun.ordinal()]);
        }
    }

    private void AppendUnitOfMeasure(long form) {
        // Debug.Assert(_result != null);
        // Debug.Assert(form >= 0);
        // Debug.Assert(form < 100);
        int index = 2;
        if (form > 20) { form %= 10; }

        if (form >= 2 && form <= 5) { index = 1; }
        else if (form == 1) { index = 0; }
        result.append(' ').append(currency.getSeniorCurrency(index));
    }
}