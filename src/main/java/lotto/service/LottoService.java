package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.User;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
/**
로또 서비스 코드
 */
public class LottoService {
    private User user;
    private List<Lotto> lottos;

    public LottoService(User user) {
        this.user = user;
    }

    public int inputMoney(){
        InputView.printInputMoneyMessage();
        String input = readLine().trim();
        return Utils.stringToInteger(input);
    }

    private int moneyToCount(int money){
        Validation.validateMoneyRange(money);
        Validation.validateDivideMoney(money);
        return money/1000;
    }

    public List<Lotto> createLottos(int count){
        for(int i = 0; i < count; i++){
            lottos.add(new Lotto(
                    LottoGenerator.getRandomLottoNum()
            ));
        }
        return lottos;
    }

    //todo 로또 유저에 넣음
    private void setLottosInUser(List<Lotto> lottos){
        this.user = new User(lottos);
    }
}
