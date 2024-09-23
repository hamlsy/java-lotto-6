package lotto;

import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class LottoGameTest {

    @DisplayName("당첨 번호 중 중복 번호가 있을 경우 예외 발생")
    @Test
    void 당첨_번호_중_중복_번호가_있을_경우_예외_발생(){
        //given
        List<Integer> winningNumbers = List.of(1,2,2,3,4,5);
        int testBonusNumber = 6;

        //when
        Throwable input1 = catchThrowable(() -> {
            new LottoGame(winningNumbers, testBonusNumber);
        });

        //then
        assertThat(input1).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복일때 예외 발생")
    @Test
    void 보너스_번호가_당첨_번호와_중복일때_예외_발생(){
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int testBonusNumber = 1;

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoGame(winningNumbers, testBonusNumber);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6자리가 아닐 때 예외 발생")
    @Test
    void 당첨_번호가_6자리가_아닐때_예외_발생(){
        //given
        List<Integer> test1 = List.of(1,2,3,4,5,6,7);
        List<Integer> test2 = List.of(1,2,3);
        int testBonusNumber = 45;

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoGame(test1, testBonusNumber);
        });

        Throwable result2 = catchThrowable(() -> {
            new LottoGame(test2, testBonusNumber);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위에 없을 때 예외 발생")
    @Test
    void 당첨_번호가_범위를_벗어날때_예외_발생(){
        //given
        List<Integer> test1 = List.of(1,2,3,4,5,57);
        List<Integer> test2 = List.of(0,2,3,4,5,6);
        int testBonusNumber = 45;

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoGame(test1, testBonusNumber);
        });

        Throwable result2 = catchThrowable(() -> {
            new LottoGame(test2, testBonusNumber);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위에 없을 때 예외 발생")
    @Test
    void 보너스_번호가_범위를_벗어날때_예외_발생(){
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int test1 = -1;
        int test2 = 60;

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoGame(winningNumbers, test1);
        });

        Throwable result2 = catchThrowable(() -> {
            new LottoGame(winningNumbers, test2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }
}
