package lotto.validation;

import lotto.view.ErrorView;

import java.util.List;

public class Validation {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int WINNING_NUMBER_MAX_SIZE = 6;
    private static final int LOTTO_PRICE_UNIT = 1_000;
    private static final String NONE_INPUT_STRING = "";


    public static void validateStringToInteger(String str){
        if(!str.chars().allMatch(Character::isDigit) || str.equals(NONE_INPUT_STRING)){
            ErrorView.stringToIntegerError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateMoneyRange(int money){
        if(money < LOTTO_PRICE_UNIT){
            ErrorView.moneyRangeError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateDivideMoney(int money){
        if(money%LOTTO_PRICE_UNIT != 0){
           ErrorView.moneyDivideError();
           throw new IllegalArgumentException();
        }
    }

    public static void validateLottoNumberRange(int num){
        if(num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER){
            ErrorView.lottoNumberRangeError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers){
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
    }
   public static void validateWinningNumbersSize(List<Integer> winningNumbers){
       if(winningNumbers.size() != WINNING_NUMBER_MAX_SIZE){
           ErrorView.lottoWinningNumberSizeError();
           throw new IllegalArgumentException();
       }
   }

   public static void validateWinningNumbersRange(List<Integer> winningNumbers){
        winningNumbers.forEach(winningNumber -> validateLottoNumberRange(winningNumber));
   }

   public static void validateBonusNumberDuplecatedInWinningNumber(int bonusNumber, List<Integer> winningNumbers){
        if(winningNumbers.contains(bonusNumber)){
            ErrorView.duplicatedBonusNumberInWinningNumbers();
            throw new IllegalArgumentException();
        }
   }

}
