package lotto.validation;

import lotto.view.ErrorView;

import java.util.List;

public class Validation {

    private static final int LOTTO_PRICE_UNIT = 1_000;

    public static void validateStringToInteger(String str){
        if(!str.chars().allMatch(Character::isDigit)){
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
        if(num < 1 || num > 45){
            ErrorView.lottoNumberRangeError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers){
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
    }
   public static void validateWinningNumbersSize(List<Integer> winningNumbers){
       if(winningNumbers.size() != 6){
           ErrorView.lottoWinningNumberSizeError();
           throw new IllegalArgumentException();
       }
   }

   public static void validateWinningNumbersRange(List<Integer> winningNumbers){
        winningNumbers.forEach(winningNumber -> validateLottoNumberRange(winningNumber));
   }


}
