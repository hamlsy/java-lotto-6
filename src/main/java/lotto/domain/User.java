package lotto.domain;

import lotto.validation.Validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
로또를 구매하는 사람. 구매량과 발급된 로또 번호, 로또 결과를 가진다.
*/
public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private int buyAmount;
    private HashMap<Rank, Integer> winningResultMap;

    public User(int buyAmount) {
        Validation.validateMoneyRange(buyAmount);
        Validation.validateDivideMoney(buyAmount);
        this.buyAmount = buyAmount;
        this.winningResultMap = Rank.initRank();
    }

    public void buyLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public HashMap<Rank, Integer> getWinningResultMap() {
        return winningResultMap;
    }
}
