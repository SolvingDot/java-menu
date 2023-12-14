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

    public void play() {
        outputView.printGameStart();

        // 코치 이름을 입력한다.
        List<String> coachNames = readNames();

        // 각 코치가 못 먹는 메뉴를 입력한다.
        Map<String, List<String>> aversionTable = readFoodAversions(coachNames);
        System.out.println(aversionTable);

        // 카테고리를 추천한다.
        CategoryRecommender categoryRecommender = new CategoryRecommender();
        List<String> categories = categoryRecommender.recommend();
        System.out.println(categories);

        // 메뉴를 추천한다.
        MenuRecommender menuRecommender = new MenuRecommender(aversionTable, categories);
        Map<String, List<String>> recommendedMenu = menuRecommender.recommend();
        System.out.println(recommendedMenu);
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
}
