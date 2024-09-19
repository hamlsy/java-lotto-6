package lotto.view;

/**
 * ErrorMessageView
 */
public class ErrorView {
    private static final String STRING_TO_INTEGER_ERROR_MESSAGE = "[ERROR] 입력 값은 숫자로 이루어져야 합니다.";
    private static final String MONEY_RANGE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";
    private static final String MONEY_DIVIDE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위로 가능합니다.";

    public static void stringToIntegerError(){
        System.out.println(STRING_TO_INTEGER_ERROR_MESSAGE);
    }

    public static void moneyRangeError(){
        System.out.println(MONEY_RANGE_ERROR_MESSAGE);
    }

    public static void moneyDivideError(){
        System.out.println(MONEY_DIVIDE_ERROR_MESSAGE);
    }
}
