package lotto.domain;

import lotto.validation.Validation;

import java.util.List;

public class Lotto {
    private static final int MINIMUM_LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validation.validateLottoNumbersDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MINIMUM_LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }


}
