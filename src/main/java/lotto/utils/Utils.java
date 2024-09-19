package lotto.utils;

import lotto.validation.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  기능 구현
 */
public class Utils {

    public static int stringToInteger(String input){
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> stringToIntegerList(String input){
        return Arrays.stream(input.split(",")).map(str -> stringToInteger(str))
                .collect(Collectors.toList());
    }
}
