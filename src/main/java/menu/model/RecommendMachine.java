package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RecommendMachine {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 5;
    private static final int DUPLICATE_LIMIT = 2;

    public List<String> recommendCategory() {
        List<String> categories = new ArrayList<>();
        while (categories.size() < MAXIMUM) {
            String category = readCategory();
            if (isNotDublicatedTwice(categories, category)) {
                categories.add(category);
            }
        }
        return categories;
    }

    private String readCategory() {
        return FoodCategory.getCategoryByNumber(Randoms.pickNumberInRange(MINIMUM, MAXIMUM));
    }

    private boolean isNotDublicatedTwice(List<String> categories, String category) {
        return categories.stream()
                .filter(name -> name.equals(category))
                .count() < DUPLICATE_LIMIT;
    }
}
