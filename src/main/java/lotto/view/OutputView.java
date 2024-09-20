package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.utils.Utils;

import java.util.HashMap;
import java.util.List;

/**
 *  입력 값에 따른 결과 View
 */
public class OutputView {
    private static final String BUY_LOTTO_MESSAGE = "%d개를 구매했습니다. \n";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개\n";

    public static void buyLottoMessage(int num){
        System.out.printf(BUY_LOTTO_MESSAGE, num);
    }

    public static void showBuyLottoList(List<Lotto> lottos){
        lottos.stream().map(l -> l.getNumbers().toString())
                .forEach(System.out::println);
    }

    //당첨 결과 출력
    public static void showWinningResult(Rank rank, int winCount){
        System.out.printf(WINNING_RESULT_MESSAGE, rank.getCorrectCount(),
                Utils.longToFormattedNumber(rank.getPrize()), winCount);
    }
}
