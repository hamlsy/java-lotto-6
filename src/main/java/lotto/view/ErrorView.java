package lotto.view;

/**
 * ErrorMessageView
 */
public class ErrorView {
    private static final String STRING_TO_INTEGER_ERROR_MESSAGE = "[ERROR] 입력 값은 숫자로 이루어져야 합니다.";
    private static final String MONEY_RANGE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";
    private static final String MONEY_DIVIDE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위로 가능합니다.";
    private static final String DUPLICATED_LOTTO_NUMBERS = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1 이상 45 이하여야 합니다.";
    private static final String LOTTO_WINNING_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 반드시 6개여야 합니다.";
    private static final String DUPLICATED_WINNING_NUMBERS = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String DUPLICATED_BONUS_NUMBER_IN_WINNING_NUMBERS = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public static void stringToIntegerError(){
        System.out.println(STRING_TO_INTEGER_ERROR_MESSAGE);
    }

    public static void moneyRangeError(){
        System.out.println(MONEY_RANGE_ERROR_MESSAGE);
    }

    public static void moneyDivideError(){
        System.out.println(MONEY_DIVIDE_ERROR_MESSAGE);
    }

    public static void lottoNumberRangeError(){
        System.out.println(LOTTO_NUMBER_RANGE_ERROR);
    }

    public static void duplicatedLottoNumbers(){
        System.out.println(DUPLICATED_LOTTO_NUMBERS);
    }

    public static void lottoWinningNumberSizeError(){
        System.out.println(LOTTO_WINNING_NUMBER_SIZE_ERROR);
    }

    public static void duplicatedWinningNumbers(){
        System.out.println(DUPLICATED_WINNING_NUMBERS);
    }

    public static void duplicatedBonusNumberInWinningNumbers(){
        System.out.println(DUPLICATED_BONUS_NUMBER_IN_WINNING_NUMBERS);
    }
}
