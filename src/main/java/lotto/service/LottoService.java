package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.domain.User;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
/**
로또 서비스 코드
 */
public class LottoService {
    private User user;
    private LottoGame lottoGame;

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_PICK_NUM = 6;
    private static final int LOTTO_PRICE_UNIT = 1_000;

    public void createLottos(){
        buyLottos();
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

    public void buyLottos(){
        this.user = new User(inputMoney());
        int count = moneyToCount(user.getBuyAmount());
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
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_PICK_NUM).stream()
                .sorted().collect(Collectors.toList());
    }

    //로또 게임 시작
    public void startLotto(){
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        Validation.validateBonusNumberDuplecatedInWinningNumber(bonusNumber, winningNumbers);
        createLottoGame(winningNumbers, bonusNumber);
    }

    private List<Integer> inputWinningNumbers(){
        InputView.printInputWinningNumbersMessage();
        String input = readLine().trim();
        List<Integer> winningNumbers = Utils.stringToIntegerList(input);
        Validation.validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    private void createLottoGame(List<Integer> winningNumbers, int bonusNumber){
        this.lottoGame = new LottoGame(winningNumbers, bonusNumber);
    }

    private int inputBonusNumber(){
        InputView.printInputBonusNumberMessage();
        String input = readLine().trim();
        int bonusNumber = Utils.stringToInteger(input);
        Validation.validateLottoNumberRange(bonusNumber);

        return bonusNumber;
    }

    public void resultLotto(){
        //로또 결과 출력
        OutputView.printWinStatisticMessage();
        HashMap<Rank, Integer> resultMap = getWinningResult(user.getLottos());
        for(Rank rank : Rank.values()){
            if(rank.getCorrectCount() >= 3){
                OutputView.showWinningResult(rank, resultMap.get(rank));
            }
        }

        // 수익률 출력
        OutputView.showTotalProfitRate(getProfitRate(user.getBuyAmount(), resultMap));
    }

    private HashMap<Rank, Integer> getWinningResult(List<Lotto> lottos){
        HashMap<Rank, Integer> resultMap = Rank.initRank();
        for(Lotto lotto : lottos){
            Rank rank = getRank(lottoGame, lotto);
            resultMap.put(rank, resultMap.get(rank)+1);
        }
        return resultMap;
    }

    private Rank getRank(LottoGame lottoGame, Lotto lotto){
        List<Integer> winningNumbers = lottoGame.getWinningNumbers();
        int bonusNumber = lottoGame.getBonusNumber();

        int correctCount = getCorrectCount(winningNumbers, lotto.getNumbers());
        int bonusCount = getBonusCount(bonusNumber, lotto.getNumbers());
        return Rank.getRank(correctCount, bonusCount);
    }

    private int getCorrectCount(List<Integer> winningNumbers, List<Integer> lottoNumbers){
        int correctCount = 0;
        for(int winningNumber : winningNumbers){
            if(lottoNumbers.contains(winningNumber)){
                correctCount++;
            }
        }
        return correctCount;
    }

    private int getBonusCount(int bonusNumber, List<Integer> lottoNumbers){
        int bonusCount = 0;
        if(lottoNumbers.contains(bonusNumber)){
            bonusCount = 1;
        }
        return bonusCount;
    }

    // 수익률 계산

    private double getProfitRate(int buyAmount, HashMap<Rank, Integer> winningResult){
        long profit = getSumWinningProfilt(winningResult);

        return (profit/(double)buyAmount)*100;
    }

    private long getSumWinningProfilt(HashMap<Rank, Integer> winningResult){
        long profit = 0;

        for(Rank rank : Rank.values()){
            profit += rank.getPrize() * winningResult.get(rank);
        }
        return profit;
    }
}
