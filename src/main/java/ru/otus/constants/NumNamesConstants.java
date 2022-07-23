package ru.otus.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.otus.enums.NounCases;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumNamesConstants {
    public static final String MINUS = "минус";
    public static final String ZERO = " ноль";

    public static final String[][] DIGITS = {
            null, {" один", " одна", " одно"}, {" два", " две", " два"},
            {" три", " три", " три"}, {" четыре", " четыре", " четыре"},
            {" пять", " пять", " пять"}, {" шесть", " шесть", " шесть"},
            {" семь", " семь", " семь"}, {" восемь", " восемь", " восемь"},
            {" девять", " девять", " девять"}
    };

    public static final String[] TENS = {
            " десять", " одинадцать", " двенадцать", " тринадцать", " четырнадцать",
            " пятнадцать", " шестнадцать", " семнадцать", " восемнадцать", " девятнадцать"
    };

    public static final String[] DOZENS = {
            null, null, " двадцать", " тридцать", " сорок", " пятьдесят", " шестьдесят",
            " семьдесят", " восемьдесят", " девяносто"
    };

    public static final String[] HUNDREDS = {
            null, " сто", " двести", " триста", " четыреста", " пятьсот", " шестьсот",
            " семьсот", " восемьсот", " девятьсот"
    };

    // declension cases for arrays
    public static final NounCases[] NOUN_CASES = {
            NounCases.MASCULINE,
            NounCases.MASCULINE,
            NounCases.FEMININE
    };
    public static final String[][] BIG_NUM_NAMES = {
            {" миллиард", " миллиарда", " миллиардов"},
            {" миллион", " миллиона", " миллионов"},
            {" тысяча", " тысячи", " тысяч"}
    };
}
