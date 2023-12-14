package menu.model;

import java.util.List;
import menu.util.Util;
import menu.view.ErrorMessage;

public class Coach {
    private static final String EMPTY = "";
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final int MINIMUM_SIZE = 2;
    private static final int MAXIMUM_SIZE = 5;
    private static final int MINIMUM_LENGTH = 2;
    private static final int MAXIMUM_LENGTH = 4;

    public List<String> readNames(String input) {
        validateEmptyInput(input);
        validateEndWithComma(input);
        List<String> names = Util.splitByComma(input);
        validateEmptyName(names);
        validateNumberOfNames(names);
        validateName(names);
        return names;
    }

    private static void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateEndWithComma(String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.COMMA_PLACE.getMessage());
        }
    }

    private static void validateEmptyName(List<String> names) {
        if (names.contains(EMPTY)) {
            throw new IllegalArgumentException(ErrorMessage.COMMA_PLACE.getMessage());
        }
    }

    private static void validateNumberOfNames(List<String> names) {
        if (names.size() < MINIMUM_SIZE || names.size() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_NAMES.getMessage());
        }
    }

    private static void validateName(List<String> names) {
        for (String name : names) {
            validateNameHasBlank(name);
            validateNameLength(name);
        }
    }

    private static void validateNameHasBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.SPACE.getMessage());
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_OF_NAME.getMessage());
        }
    }
}
