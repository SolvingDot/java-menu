package menu.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printRecommendationStart() {
        System.out.println(Message.OUTPUT_START.message);
        System.out.println();
    }

    public void printRecommendationResult(List<String> categories, Map<String, List<String>> recommendedMenu) {
        System.out.println(Message.OUTPUT_RECOMMENDATION_RESULT.message);
        System.out.println(Message.OUTPUT_DAYS.message);
        System.out.println(String.format(Message.OUTPUT_CATEGORY.message, categories.toArray()));
        for (String coach : recommendedMenu.keySet()) {
            System.out.print(String.format((Message.OUTPUT_COACH.message), coach));
            System.out.println(String.format(Message.OUTPUT_MENU.message, recommendedMenu.get(coach).toArray()));
        }
        System.out.println();
    }

    public void printRecommendationFinish() {
        System.out.println(Message.OUTPUT_FINISH.message);
    }

    private enum Message {
        OUTPUT_START("점심 메뉴 추천을 시작합니다."),
        OUTPUT_RECOMMENDATION_RESULT("메뉴 추천 결과입니다."),
        OUTPUT_DAYS("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
        OUTPUT_CATEGORY("[ 카테고리 | %s | %s | %s | %s | %s ]"),
        OUTPUT_COACH("[ %s "),
        OUTPUT_MENU("| %s | %s | %s | %s | %s ]"),
        OUTPUT_FINISH("추천을 완료했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
