package lotto.util;

import static lotto.constant.ErrorType.PURCHASE_AMOUNT_TYPE_ERROR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConversion {

    private static final String SPLIT_EXPRESSION = ",";

    public static int stringToInt(String input) {

        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_TYPE_ERROR.getMessage());
        }

        return purchaseAmount;
    }

    public static List<String> splitInputByComma(String input) {
        String[] splitInput = input.split(SPLIT_EXPRESSION);

        return Arrays.asList(splitInput);
    }

    public static List<Integer> stringToIntList(String input) {

        List<String> playerNumbers = splitInputByComma(input);

        return playerNumbers.stream()
                .map(TypeConversion::stringToInt)
                .collect(Collectors.toList());
    }
}
