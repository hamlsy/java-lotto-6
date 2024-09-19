package lotto.validation;

import lotto.view.ErrorView;

public class Validation {

    public static void validateStringToInteger(String str){
        if(!str.chars().allMatch(Character::isDigit)){
            ErrorView.stringToIntegerError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateMoneyRange(int money){
        if(money < 1000){
            ErrorView.moneyRangeError();
            throw new IllegalArgumentException();
        }
    }

    // 1000원 단위 검증
    public static void validateDivideMoney(int money){
        if(money%1000 != 0){
           ErrorView.moneyDivideError();
           throw new IllegalArgumentException();
        }
    }
}
