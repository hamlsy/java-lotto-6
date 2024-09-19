package lotto.domain;

import java.util.List;

/*
로또를 구매하는 사람. 구매 금액과 발급된 로또 번호를 가진다.
*/
public class User {
    private List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
