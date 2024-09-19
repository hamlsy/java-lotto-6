package lotto.utils;

import lotto.validation.Validation;

/**
 *  기능 구현
 */
public class Utils {

    public static int stringToInteger(String input){
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }
}
