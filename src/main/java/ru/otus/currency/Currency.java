package ru.otus.currency;

import ru.otus.enums.NounCases;

public interface Currency {
    static final String MINUS = "минус";
    static final String ZERO  = "ноль";

    static final String[] THOUSAND = {"тысяча", "тысячи", "тысяч"};
    static final String[] MILLION  = {"миллион", "миллиона", "миллионов"};
    static final String[] MILLIARD = {"миллиард", "миллиарда", "миллиардов"};

    static final String[][] DIGITS = {
            null, {"один", "одна", "одно"}, {"два", "две", "два"},
            {"три", "три", "три"}, {"четыре", "четыре", "четыре"},
            {"пять", "пять", "пять"}, {"шесть", "шесть", "шесть"},
            {"семь", "семь", "семь"}, {"восемь", "восемь", "восемь"},
            {"девять", "девять", "девять"}
    };

    static final String[] TENS = {
            "десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };

    static final String[] DOZENS = {
            null, null, "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"
    };

    static final String[] HUNDREDS = {
            null, "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот",
            "семьсот", "восемьсот", "девятьсот"
    };

    String getSeniorCurrency(int index);

    String getJuniorCurrency(int index);

}
