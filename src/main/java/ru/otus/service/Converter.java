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
            AppendNumber(value, NounCases.MASCULINE); /// сужающие приведение типов!!!
            AppendUnitOfMeasure(value % 100, currency.MILLIARD);
            userInput %= MILLIARD;
        }

        if(userInput >= MILLION) {
            value = userInput / MILLION;
            AppendNumber(value, NounCases.MASCULINE);
            AppendUnitOfMeasure(value % 100, currency.MILLION);
            userInput %= MILLION;
        }

        if(userInput >= THOUSAND) {
            value = userInput / THOUSAND;
            AppendNumber(value, NounCases.FEMININE);
            AppendUnitOfMeasure(value % 100, currency.THOUSAND);
            userInput %= THOUSAND;
        }

        if (userInput > 0) {
            AppendNumber(userInput, NounCases.MASCULINE);
            AppendUnitOfMeasure(userInput, currency.THOUSAND);
        }
        AppendUnitOfMeasure(5, currency.getSeniorCurrency());

      return result.toString();
    }

    private void AppendNumber(long value, NounCases noun) {
        //Debug.Assert(_result != null);
        //Debug.Assert(value > 0);
        //Debug.Assert(value < 1000);

        // Write hundreds

        if (value >= 100) {
            long index = value / 100;
            value = value % 100;
            this.result.append(' ');
            this.result.append(currency.HUNDREDS[(int) index]);
        }

        // Write dozens

        if (value >= 20) {
            long index = value / 10;
            value = value % 10;
            this.result.append(' ');
            this.result.append(currency.DOZENS[(int) index]);
        } else if (value >= 10) {
            long index = value - 10;
            this.result.append(' ');
            this.result.append(currency.TENS[(int) index]);
            return;
        }

        // Write digit
        if (value > 0) {
            this.result.append(' ');
            this.result.append(currency.DIGITS[(int) value][noun.ordinal()]);
        }
    }

    private void AppendUnitOfMeasure(long form, String[] date) {
        // Debug.Assert(_result != null);
        // Debug.Assert(form >= 0);
        // Debug.Assert(form < 100);

        if (form > 20) { form %= 10; }

        int index = 2;
        if (form == 1) {
            index = 0;
        } else if (form >= 2 && form < 5) {
            index = 1;
        }

        result.append(' ').append(date[index]);
    }
}