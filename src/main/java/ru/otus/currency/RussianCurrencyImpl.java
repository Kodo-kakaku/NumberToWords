package ru.otus.currency;

public class RussianCurrencyImpl implements Currency {

    private static final String[] RUBLES = {"рубль", "рубля", "рублей"};
    private static final String[] KOPECK = {"копейка", "копейки", "копеек"};

    @Override
    public String getSeniorCurrency(int index) {
        return RUBLES[index];
    }

    @Override
    public String getJuniorCurrency(int index) {
        return KOPECK[index];
    }
}
