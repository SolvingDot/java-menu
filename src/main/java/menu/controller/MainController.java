package menu.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.model.Coach;
import menu.model.FoodAversion;
import menu.model.CategoryRecommender;
import menu.model.MenuRecommender;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRecommendation() {
        outputView.printRecommendationStart();
        List<String> coachNames = readNames();
        Map<String, List<String>> aversionTable = readFoodAversions(coachNames);

        List<String> categories = recommendCategory();
        Map<String, List<String>> recommendedMenu = recommendMenu(aversionTable, categories);
        outputView.printRecommendationResult(categories, recommendedMenu);
        outputView.printRecommendationFinish();
    }

    private List<String> readNames() {
        while (true) {
            try {
                Coach coach = new Coach();
                return coach.readNames(inputView.readName());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<String, List<String>> readFoodAversions(List<String> coachNames) {
        Map<String, List<String>> aversionTable = new LinkedHashMap<>();
        for (String name : coachNames) {
            List<String> foodAversions = readFoodAversion(name);
            aversionTable.put(name, foodAversions);
        }
        return aversionTable;
    }

    private List<String> readFoodAversion(String name) {
        while (true) {
            try {
                FoodAversion foodAversion = new FoodAversion();
                return foodAversion.read(inputView.readFoodAversion(name));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> recommendCategory() {
        CategoryRecommender categoryRecommender = new CategoryRecommender();
        return categoryRecommender.recommend();
    }

    private Map<String, List<String>> recommendMenu(Map<String, List<String>> aversionTable,
                                                    List<String> categories) {
        MenuRecommender menuRecommender = new MenuRecommender(aversionTable, categories);
        return menuRecommender.recommend();
    }
}
