package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.domain.User;
import lotto.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
로또 서비스 코드
 */
public class LottoService {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_PICK_NUM = 6;

    public void buyLottos(User user){
        int count = Utils.moneyToCount(user.getBuyAmount());
        for(int i = 0; i < count; i++){
            user.buyLotto(createRandomLotto());
        }
    }

    private Lotto createRandomLotto(){
        return new Lotto(getRandomLottoNum());
    }

    private List<Integer> getRandomLottoNum(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_PICK_NUM).stream()
                .sorted().collect(Collectors.toList());
    }

    public long getTotalWinningProfilt(User user){
        long profit = 0;
        for(Rank rank : Rank.values()){
            profit += rank.getPrize() * user.getWinningResultMap().get(rank);
        }
        return profit;
    }

    public void getWinningResult(LottoGame lottoGame, User user){
        HashMap<Rank, Integer> resultMap = user.getWinningResultMap();
        for(Lotto lotto : user.getLottos()){
            Rank rank = getRank(lottoGame, lotto);
            resultMap.put(rank, resultMap.get(rank)+1);
        }
    }

    private Rank getRank(LottoGame lottoGame, Lotto lotto){
        int correctCount = getCorrectCount(lottoGame.getWinningNumbers(), lotto.getNumbers());
        int bonusCount = getBonusCount(lottoGame.getBonusNumber(), lotto.getNumbers());

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
        return lottoNumbers.contains(bonusNumber) ? 1 : 0;
    }

}
