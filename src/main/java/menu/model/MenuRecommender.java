package menu.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class MenuRecommender {
    private final Map<String, List<String>> aversionTable;
    private final List<String> categories;

    public MenuRecommender(Map<String, List<String>> aversionTable, List<String> categories) {
        this.aversionTable = aversionTable;
        this.categories = categories;
    }

    public Map<String, List<String>> recommend() {
        Map<String, List<String>> recommendedMenu = makeInitialTable();
        recommendForEachDays(recommendedMenu);
        return recommendedMenu;
    }

    private Map<String, List<String>> makeInitialTable() {
        Map<String, List<String>> recommendedMenu = new LinkedHashMap<>();
        for (String coach : aversionTable.keySet()) {
            recommendedMenu.put(coach, new ArrayList<>());
        }
        return recommendedMenu;
    }

    private void recommendForEachDays(Map<String, List<String>> recommendedMenu) {
        for (String category : categories) {
            List<String> menus = FoodCategory.getMenuByCategory(category);
            recommendToEachCoach(menus, recommendedMenu);
        }
    }

    private void recommendToEachCoach(List<String> menus, Map<String, List<String>> recommendedMenu) {
        for (String coach : aversionTable.keySet()) {
            recommendUntilValid(menus, coach, recommendedMenu);
        }
    }

    private void recommendUntilValid(List<String> menus, String coach, Map<String, List<String>> recommendedMenu) {
        while (true) {
            String menu = Randoms.shuffle(menus).get(0);
            if (isValidRecommendation(menu, coach, recommendedMenu)) {
                recommendedMenu.get(coach).add(menu);
                break;
            }
        }
    }

    private boolean isValidRecommendation(String menu, String coach, Map<String, List<String>> recommendedMenu) {
        return !aversionTable.get(coach).contains(menu) && !recommendedMenu.get(coach).contains(menu);
    }
}
