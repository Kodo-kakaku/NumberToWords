package ru.otus.service;

import ru.otus.constants.NumNamesConstants;
import ru.otus.currency.Currency;
import ru.otus.enums.NounCases;

public class Converter {
    private long userInput;
    private final Currency currency;
    private final StringBuilder result;
    private static final long[] BIG_NUMS = {
            1_000_000_000L,
            1_000_000L,
            1_000L
    };

    public Converter(long userInput, Currency currency) {
        this.userInput = userInput;
        this.currency = currency;
        this.result = new StringBuilder(100);
    }

    public String convert() {
        if(userInput == 0) {
            result.append(NumNamesConstants.ZERO);
            appendUnit(userInput, currency.getSeniorCurrency());
            return result.toString().trim();
        }

        if (userInput < 0) {
            result.append(NumNamesConstants.MINUS);
            userInput = -userInput;
        }

        return performConversion();
    }

    private String performConversion() {
        for (int i = 0; i < BIG_NUMS.length; i++) {
            if (userInput >= BIG_NUMS[i]) {
                long quantity = userInput / BIG_NUMS[i];
                appendNumber(quantity, NumNamesConstants.NOUN_CASES[i]);
                appendUnit(quantity % 100, NumNamesConstants.BIG_NUM_NAMES[i]);
                userInput %= BIG_NUMS[i];
            }
        }

        if (userInput > 0) {
            appendNumber(userInput, NumNamesConstants.NOUN_CASES[0]);
        }
        appendUnit(userInput, currency.getSeniorCurrency());

      return result.toString().trim();
    }

    private void appendNumber(long quantity, NounCases nounCases) {
        if (quantity >= 100) {
            long index = quantity / 100;
            quantity %= 100;
            this.result.append(NumNamesConstants.HUNDREDS[(int) index]);
        }

        if (quantity >= 20) {
            long index = quantity / 10;
            quantity %= 10;
            this.result.append(NumNamesConstants.DOZENS[(int) index]);
        } else if (quantity >= 10) {
            long index = quantity - 10;
            this.result.append(NumNamesConstants.TENS[(int) index]);
            return;
        }

        if (quantity > 0) {
            this.result.append(NumNamesConstants.DIGITS[(int) quantity][nounCases.ordinal()]);
        }
    }

    private void appendUnit(long userInput, String[] date) {
        if (userInput > 20) { userInput %= 10; }

        int index = 2;
        if (userInput >= 2 && userInput < 5) {
            index = 1;
        } else if (userInput == 1) {
            index = 0;
        }

        result.append(date[index]);
    }
}