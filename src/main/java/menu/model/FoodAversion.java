package menu.model;

import java.util.ArrayList;
import java.util.List;
import menu.util.Util;
import menu.view.ErrorMessage;

public class FoodAversion {
    private static final String COMMA = ",";
    private static final String EMPTY = "";
    private static final int MAXIMUM_SIZE = 2;

    public List<String> read(String input) {
        if (input.isEmpty()) {
            return readNoFood();
        }
        if (!input.contains(COMMA)) {
            return readOneFood(input);
        }
        return readFoodsMoreThanOne(input);
    }

    private static List<String> readNoFood() {
        List<String> foodAversions = new ArrayList<>();
        foodAversions.add(EMPTY);
        return foodAversions;
    }

    private List<String> readOneFood(String input) {
        List<String> foodAversions = new ArrayList<>();
        if (!foodAversionIsInMenu(input)) {
            throw new IllegalArgumentException(ErrorMessage.FOOD_OUT_OF_MENU.getMessage());
        }
        foodAversions.add(input);
        return foodAversions;
    }

    private List<String> readFoodsMoreThanOne(String input) {
        validateEndWithComma(input);
        List<String> foodAversions = Util.splitByComma(input);
        validateEmptyFood(foodAversions);
        validateNumberOfFood(foodAversions);
        validateFoodAversionIsInMenu(foodAversions);
        return foodAversions;
    }

    private static void validateEndWithComma(String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.COMMA_PLACE.getMessage());
        }
    }

    private static void validateEmptyFood(List<String> foodAversions) {
        if (foodAversions.contains(EMPTY)) {
            throw new IllegalArgumentException(ErrorMessage.COMMA_PLACE.getMessage());
        }
    }

    private static void validateNumberOfFood(List<String> foodAversions) {
        if (foodAversions.size() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_NAMES.getMessage());
        }
    }

    private void validateFoodAversionIsInMenu(List<String> foodAversions) {
        for (String food : foodAversions) {
            if (!foodAversionIsInMenu(food)) {
                throw new IllegalArgumentException(ErrorMessage.FOOD_OUT_OF_MENU.getMessage());
            }
        }
    }

    private boolean foodAversionIsInMenu(String food) {
        for (FoodCategory foodCategory : FoodCategory.values()) {
            if (foodCategory.getMenu().contains(food)) {
                return true;
            }
        }
        return false;
    }
}
