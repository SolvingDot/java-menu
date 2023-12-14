package menu.controller;

import java.util.List;
import menu.model.Coach;
import menu.model.FoodCategory;
import menu.model.RecommendMachine;
import menu.util.Util;
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
        Coach coach = new Coach();
        List<String> coachNames = coach.readNames(inputView.readName());

        // 코치가 못 먹는 메뉴를 입력한다.

        // 카테고리를 추천한다.
        RecommendMachine recommendMachine = new RecommendMachine();
        List<String> categories = recommendMachine.recommendCategory();

        // 메뉴를 추천한다.
    }
}
