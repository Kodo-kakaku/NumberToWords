package ru.otus.service;

import ru.otus.currency.Currency;

public class Converter {
    private final long THOUSAND = 1_000L;
    private final long MILLION  = 1_000_000L;
    private final long MILLIARD = 1_000_000_000L;
    private final long TRILLION = 1_000_000_000_000L;

    private final long MAX_VALUE = TRILLION - 1;
    private StringBuilder result;

    // TODO Implementation of currency transfer in the method
    public String Convert(long userInput, Currency currency) {
        return null;
    }
}