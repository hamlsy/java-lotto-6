package lotto.view;

/**
 *  입력 값에 따른 결과 View
 */
public class OutputView {
    private static final String BUY_LOTTO_MESSAGE = "%s개를 구매했습니다.";
    //todo 구매 메시지

    public static void buyLottoMessage(int num){
        System.out.printf(BUY_LOTTO_MESSAGE, num);
    }
}
