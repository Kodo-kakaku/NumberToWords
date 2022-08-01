package ru.otus.currency;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RussianCurrencyImpl implements Currency {
    private static final String[] RUBLES = {" рубль", " рубля", " рублей"};

    @Override
    public String[] getSeniorCurrency() { return RUBLES; }

}
