package lotto.domain;

/**
 * 당첨 순위 (맞힌 개수, 보너스 볼, 당첨 금액)
 */
public enum Rank {
    FIRST_RANK(6, 1,2_000_000_000L),
    SECOND_RANK(5, 1,30_000_000L),
    THIRD_RANK(5, 0, 1_500_000L),
    FOURTH_RANK(4, 0,50_000L),
    FIFTH_RANK(3, 0, 5_000L),
    NO_RANK_TWO(0, 0, 0L),
    NO_RANK_ONE(0, 0, 0L),
    NO_RANK_ZERO(0, 0, 0L);


    private final int correctCount;
    private final int bonusCount;
    private final long prize;

    Rank(int correctCount, int bonusCount, long prize) {
        this.correctCount = correctCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }
}
