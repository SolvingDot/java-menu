package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 5;
    private static final int DUPLICATE_LIMIT = 2;

    public List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < MAXIMUM) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
            if (isNotDublicatedTwice(randomNumbers, randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private boolean isNotDublicatedTwice(List<Integer> randomNumbers, int randomNumber) {
        return randomNumbers.stream()
                .filter(number -> number.equals(randomNumber))
                .count() < DUPLICATE_LIMIT;
    }
}
