package menu.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance(){
        return instance;
    }
    private OutputView() {
    }

    public void printGameStart() {
        System.out.println(Message.OUTPUT_GAME_START.message);
    }

    private enum Message {
        OUTPUT_GAME_START("점심 메뉴 추천을 시작합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
