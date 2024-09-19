package lotto.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
/**
 * 로또 랜덤 번호 생성기
 */
public class LottoGenerator {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_PICK_NUM = 6;

    //생성기 메서드

    public static List<Integer> getRandomLottoNum(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_PICK_NUM);
    }


}
