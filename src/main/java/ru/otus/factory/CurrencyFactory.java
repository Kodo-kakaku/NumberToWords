package ru.otus.factory;

import ru.otus.currency.RussianCurrencyImpl;
import ru.otus.enums.CurrencyNames;

public class CurrencyFactory {
    public RussianCurrencyImpl createCurrency(CurrencyNames name) {
        return switch(name) {
            case RUBLES -> new RussianCurrencyImpl();
            case DOLLARS -> null; // some realization in future for example;
            default -> null;
        };
    }
}
