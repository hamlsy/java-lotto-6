package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;


/**
 * Model과 View를 연결, Model을 호출 및 반환
 * input, output 처리
 */
public class LottoController {

    private final int MINIMUM_WINNING_CORRECT_COUNT = 3;

    private LottoService lottoService;
    private User user;
    private LottoGame lottoGame;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start(){
        beforeLotto();
        startLotto();
        resultLotto();
    }

    public void beforeLotto(){
        buyLottos();
        lottoService.buyLottos(user);
        OutputView.showBuyLottoList(user.getLottos());
    }

    private void buyLottos(){
        user = new User(inputMoney());
        OutputView.buyLottoMessage(getUserBuyLottoCount());
    }

    private int getUserBuyLottoCount(){
        return Utils.moneyToCount(user.getBuyAmount());
    }

    private int inputMoney(){
        InputView.printInputMoneyMessage();
        String input = readLine().trim();
        return Utils.stringToInteger(input);
    }

    public void startLotto(){
        lottoGame = new LottoGame(inputWinningNumbers(), inputBonusNumber());
    }

    private List<Integer> inputWinningNumbers(){
        InputView.printInputWinningNumbersMessage();
        String input = readLine().trim();
        return Utils.stringToIntegerList(input);
    }

    private int inputBonusNumber(){
        InputView.printInputBonusNumberMessage();
        String input = readLine().trim();
        return Utils.stringToInteger(input);
    }

    public void resultLotto(){
        OutputView.printWinStatisticMessage();
        printResultLotto(getWinningResult());
        long profit = getWinningProfit();
        int buyAmount = user.getBuyAmount();
        printTotalProfitRate(profit, buyAmount);
    }

    private HashMap<Rank, Integer> getWinningResult(){
        return lottoService.getWinningResult(lottoGame, user.getLottos());
    }

    private long getWinningProfit(){
        return lottoService.getTotalWinningProfilt(lottoGame, user.getLottos());
    }

    private void printResultLotto(HashMap<Rank, Integer> resultMap){
        for(Rank rank : Rank.values()){
            if(rank.getCorrectCount() >= MINIMUM_WINNING_CORRECT_COUNT){
                OutputView.showWinningResult(rank, resultMap.get(rank));
            }
        }
    }

    private void printTotalProfitRate(long profit, int buyAmount){
        OutputView.showTotalProfitRate(Utils.getProfitRate(profit, buyAmount));
    }
}
