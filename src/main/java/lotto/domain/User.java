package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
로또를 구매하는 사람. 구매량과 발급된 로또 번호, 로또 결과를 가진다.
*/
public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private HashMap<Rank, Integer> lottoResult = new HashMap<>();
    private int buyAmount;

    public User(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public void buyLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public HashMap<Rank, Integer> getLottoResult(){
        return lottoResult;
    }


}
