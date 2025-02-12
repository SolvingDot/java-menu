package menu.model;

import java.util.List;
import menu.view.ErrorMessage;

public enum FoodCategory {
    JAPANESE("일식", 1, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN("한식", 2, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE("중식", 3, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", 4, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", 5, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final String category;
    private final int number;
    private final List<String> menu;

    FoodCategory(String category, int number, List<String> menu) {
        this.category = category;
        this.number = number;
        this.menu = menu;
    }

    public String getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }

    public List<String> getMenu() {
        return menu;
    }

    public static String getCategoryByNumber(int number) {
        for (FoodCategory foodCategory : FoodCategory.values()) {
            if (foodCategory.getNumber() == number) {
                return foodCategory.getCategory();
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MISMATCH_NUMBER.getMessage());
    }

    public static List<String> getMenuByCategory(String category) {
        for (FoodCategory foodCategory : FoodCategory.values()) {
            if (foodCategory.getCategory().equals(category)) {
                return foodCategory.getMenu();
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MISMATCH_CATEGORY.getMessage());
    }
}
