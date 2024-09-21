package lotto.controller;

import lotto.domain.Rank;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.Utils;
import lotto.validation.Validation;
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

    private LottoService lottoService;
    private User user;

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
        OutputView.buyLottoMessage(Utils.moneyToCount(user.getBuyAmount()));
    }

    private int inputMoney(){
        InputView.printInputMoneyMessage();
        String input = readLine().trim();
        return Utils.stringToInteger(input);
    }

    public void startLotto(){
       lottoService.startLotto(inputWinningNumbers(), inputBonusNumber());
    }

    private List<Integer> inputWinningNumbers(){
        InputView.printInputWinningNumbersMessage();
        String input = readLine().trim();
        List<Integer> winningNumbers = Utils.stringToIntegerList(input);
        Validation.validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    private int inputBonusNumber(){
        InputView.printInputBonusNumberMessage();
        String input = readLine().trim();
        int bonusNumber = Utils.stringToInteger(input);
        Validation.validateLottoNumberRange(bonusNumber);

        return bonusNumber;
    }

    public void resultLotto(){
        OutputView.printWinStatisticMessage();
        printResultLotto(lottoService.getWinningResult(user.getLottos()));
        long profit = lottoService.getTotalWinningProfilt(user);
        int buyAmount = user.getBuyAmount();
        printTotalProfitRate(profit, buyAmount);
    }

    private void printResultLotto(HashMap<Rank, Integer> resultMap){
        for(Rank rank : Rank.values()){
            if(rank.getCorrectCount() >= 3){
                OutputView.showWinningResult(rank, resultMap.get(rank));
            }
        }
    }

    private void printTotalProfitRate(long profit, int buyAmount){
        OutputView.showTotalProfitRate(Utils.getProfitRate(profit, buyAmount));
    }
}
