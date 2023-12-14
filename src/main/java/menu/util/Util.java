package menu.util;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(Regex.COMMA.regex));
    }

    private enum Regex {
        SPACE(" "), NO_SPACE(""),
        SQUARE_BRACKETS_START("["), SQUARE_BRACKETS_END("]"),
        COMMA(",");

        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }

    private Util() {
    }
}
