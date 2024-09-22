package lotto.domain;

import lotto.validation.Validation;

import java.util.List;

public class LottoGame {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoGame(List<Integer> winningNumbers, int bonusNumber) {
        Validation.validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        Validation.validateLottoNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
        Validation.validateBonusNumberNotInWinningNumber(bonusNumber, winningNumbers);
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
