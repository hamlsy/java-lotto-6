package lotto.domain;

import java.util.HashMap;

/**
 * 당첨 순위 (맞힌 개수, 보너스 볼, 당첨 금액)
 */
public enum Rank {
    NO_RANK_ZERO(0, 0, 0L),
    NO_RANK_ONE(1, 0, 0L),
    NO_RANK_TWO(2, 0, 0L),
    FIFTH_RANK(3, 0, 5_000L),
    FOURTH_RANK(4, 0,50_000L),
    THIRD_RANK(5, 0, 1_500_000L),
    SECOND_RANK(5, 1,30_000_000L),
    FIRST_RANK(6, 0,2_000_000_000L);

    private final int correctCount;
    private final int bonusCount;
    private final long prize;

    Rank(int correctCount, int bonusCount, long prize) {
        this.correctCount = correctCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public long getPrize() {
        return prize;
    }

    public static HashMap<Rank, Integer> initRank(){
        HashMap<Rank, Integer> inithashMap = new HashMap<>();
        for(Rank rank: Rank.values()){
            inithashMap.put(rank, 0);
        }
        return inithashMap;
    }

    //Get Rank
    public static Rank getRank(int correctCount, int bonusCount){
        for(Rank rank: Rank.values()){
            if(rank.correctCount == correctCount && rank.bonusCount == bonusCount){
                return rank;
            }
        }
        return null;
    }
}
