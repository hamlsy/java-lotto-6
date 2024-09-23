package lotto;

import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class UserTest {

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외 발생")
    @Test
    void 구매_금액이_1000원_단위가_아니면_예외_발생(){
        //given
        int amountA = 1050;
        int amountB = 9001;

        //when
        Throwable buy1 = catchThrowable(() -> {
            new User(amountA);
        });

        Throwable buy2 = catchThrowable(() -> {
            new User(amountB);
        });

        //then
        assertThat(buy1).isInstanceOf(IllegalArgumentException.class);
        assertThat(buy2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 미만이면 예외 발생")
    @Test
    void 구매_금액이_1000원_미만이면_예외_발생(){
        //given
        int amountA = 999;
        int amountB = 200;

        //when
        Throwable buy1 = catchThrowable(() -> {
            new User(amountA);
        });

        Throwable buy2 = catchThrowable(() -> {
            new User(amountB);
        });

        //then
        assertThat(buy1).isInstanceOf(IllegalArgumentException.class);
        assertThat(buy2).isInstanceOf(IllegalArgumentException.class);
    }
}
