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
        this.result = new StringBuilder();

        if (this.userInput < 0) {
            this.result.append(this.currency.MINUS);
            this.userInput = -this.userInput;
        } else if (this.userInput == 0) {
            this.result.append(this.currency.ZERO);
        }

        if (this.userInput >= TRILLION) {
            System.out.println("EXCEPTION");
        }

        if (this.userInput >= this.MILLIARD) {
            long value = this.userInput / this.MILLIARD;
            AppendNumber((int)value, NounCases.MASCULINE); /// сужающие приведение типов!!!
            //AppendUnitOfMeasure(value % 100, unit);
            userInput = userInput % MILLIARD;
        }
/*
        // Write millions
        if (number >= E6) {
            var value = number / E6;
            Append((int) value, Constants.Е6Unit);
            number = number % E6;
        }

        // Write thouthands
        if (number >= E3) {
            var value = number / E3;
            Append((int) value, Constants.Е3Unit);
            number = number % E3;
        }

 */     return null;
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
/*
    private void AppendUnitOfMeasure(int form, UnitOfMeasure unit) {
        Debug.Assert(_result != null);
        Debug.Assert(form >= 0);
        Debug.Assert(form < 100);

        if (form > 20) {
            form = form % 10;
        }

        if (form >= 5) {
            _result.Append(' ');
            _result.Append(unit.Form5);
        } else if (form >= 2) {
            _result.Append(' ');
            _result.Append(unit.Form2);
        } else if (form == 1) {
            _result.Append(' ');
            _result.Append(unit.Form1);
        } else    // 0 - should use form 5
        {
            _result.Append(' ');
            _result.Append(unit.Form5);
        }
    }
*/
}