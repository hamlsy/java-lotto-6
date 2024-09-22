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
    private LottoGame lottoGame;

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_PICK_NUM = 6;

    public void buyLottos(User user){
        int count = Utils.moneyToCount(user.getBuyAmount());
        for(int i = 0; i < count; i++){
            user.buyLotto(
                    new Lotto(getRandomLottoNum())
            );
        }
    }

    private List<Integer> getRandomLottoNum(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_PICK_NUM).stream()
                .sorted().collect(Collectors.toList());
    }

    public void startLotto(List<Integer> winningNumbers, int bonusNumber){
        Validation.validateBonusNumberNotInWinningNumber(bonusNumber, winningNumbers);
        createLottoGame(winningNumbers, bonusNumber);
    }

    private void createLottoGame(List<Integer> winningNumbers, int bonusNumber){
        this.lottoGame = new LottoGame(winningNumbers, bonusNumber);
    }

    public long getTotalWinningProfilt(User user){
        HashMap<Rank, Integer> winningResult = getWinningResult(user.getLottos());
        long profit = 0;

        for(Rank rank : Rank.values()){
            profit += rank.getPrize() * winningResult.get(rank);
        }
        return profit;
    }

    public HashMap<Rank, Integer> getWinningResult(List<Lotto> lottos){
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


}
