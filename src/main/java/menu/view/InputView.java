package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance(){
        return instance;
    }
    private InputView() {
    }

    public String readName() {
        System.out.println(Message.INPUT_NAME.message);
        return Console.readLine();
    }


    private enum Message {
        INPUT_NAME("코치의 이름을 입력해 주세요. (, 로 구분)");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
