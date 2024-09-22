package lotto.utils;

import lotto.validation.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  기능 구현
 */
public class Utils {
    private static final int LOTTO_PRICE_UNIT = 1_000;
    private static final int RATE_VALUE = 100;
    private static final String WIN_NUMBER_SPLIT_STRING = ",";
    private static final String LONG_FORMAT_STRING = "%,d";

    public static int stringToInteger(String input){
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> stringToIntegerList(String input){
        return Arrays.stream(input.split(WIN_NUMBER_SPLIT_STRING)).map(str -> stringToInteger(str))
                .collect(Collectors.toList());
    }

    public static String longToFormattedNumber(long number){
        return String.format(LONG_FORMAT_STRING, number);
    }

    public static int moneyToCount(int money){
        Validation.validateMoneyRange(money);
        Validation.validateDivideMoney(money);
        return money/LOTTO_PRICE_UNIT;
    }

    public static double getProfitRate(long profit, int buyAmount){
        return (profit/(double)buyAmount)*RATE_VALUE;
    }

}
