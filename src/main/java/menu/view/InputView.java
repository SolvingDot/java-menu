package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public String readName() {
        System.out.println(Message.INPUT_NAME.message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String readFoodAversion(String name) {
        System.out.println(String.format(Message.INPUT_FOOD_AVERSION.message, name));
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    private enum Message {
        INPUT_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
        INPUT_FOOD_AVERSION("%s(이)가 못 먹는 메뉴를 입력해 주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
