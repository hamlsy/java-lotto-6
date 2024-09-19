package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.User;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
/**
로또 서비스 코드
 */
public class LottoService {
    private User user;

    private static final int LOTTO_PRICE_UNIT = 1_000;

    public void createLottos(){
        buyLottos(moneyToCount(inputMoney()));

    }

    public int inputMoney(){
        InputView.printInputMoneyMessage();
        String input = readLine().trim();
        return Utils.stringToInteger(input);
    }

    private int moneyToCount(int money){
        Validation.validateMoneyRange(money);
        Validation.validateDivideMoney(money);
        return money/LOTTO_PRICE_UNIT;
    }

    public void buyLottos(int count){
        this.user = new User(count);
        for(int i = 0; i < count; i++){
            user.buyLotto(
                    new Lotto(LottoGenerator.getRandomLottoNum())
            );
        }
        OutputView.buyLottoMessage(count);
        OutputView.showBuyLottoList(user.getLottos());
    }



}
