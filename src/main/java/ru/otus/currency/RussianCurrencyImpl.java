package ru.otus.currency;

public class RussianCurrencyImpl implements Currency {

    private static final String[] RUBLES = {"рубль", "рубля", "рублей"};
    private static final String[] KOPECK = {"копейка", "копейки", "копеек"};

    @Override
    public String[] getSeniorCurrency() {
        return RUBLES;
    }

    @Override
    public String[] getJuniorCurrency() {
        return KOPECK;
    }
}
