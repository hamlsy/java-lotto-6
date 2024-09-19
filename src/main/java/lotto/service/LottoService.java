package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
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

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_PICK_NUM = 6;
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
                    new Lotto(getRandomLottoNum())
            );
        }
        OutputView.buyLottoMessage(count);
        OutputView.showBuyLottoList(user.getLottos());
    }

    //생성기 메서드
    private List<Integer> getRandomLottoNum(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_PICK_NUM);
    }


    //todo start 단계, 당첨번호 입력, 보너스 번호 입력 부분
    public void startLotto(){

    }

    private List<Integer> inputWinningNumbers(){
        String input = readLine().trim();
        List<Integer> winningNumbers = Utils.stringToIntegerList(input);
        Validation.validateWinningNumbers(winningNumbers);

        return null;
    }

    private int inputBonusNumber(){
        String input = readLine().trim();
        //todo 숫자인가?
        // 1~45 범위를 가지는가?
        // 당첨 번호랑 겹치는가?
        return 0;
    }

    //todo 결과 출력 단계, 당첨 통계 및 수익률 계산 부분
    public void resultLotto(){

    }

}
