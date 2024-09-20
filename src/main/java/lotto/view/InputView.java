package lotto.view;

/**
 *  입력 콘솔 메시지
 */
public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해주세요.";
    private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUBMER = "보너스 번호를 입력해주세요.";


    public static void printInputMoneyMessage(){
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public static void printInputWinningNumbersMessage(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public static void printInputBonusNumberMessage(){
        System.out.println(INPUT_BONUS_NUBMER);
    }

}
