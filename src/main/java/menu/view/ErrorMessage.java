package menu.view;

public enum ErrorMessage {
    EMPTY_INPUT("아무 입력이 없습니다. 코치 이름을 입력해주세요."),
    COMMA_PLACE("쉼표는 이름을 구분할 때 사용해주세요."),
    NUMBER_OF_NAMES("코치는 최소 2명, 최대 5명을 입력해주세요."),
    SPACE("이름은 띄어쓰지 말고 입력해주세요."),
    LENGTH_OF_NAME("이름은 최소 2글자, 최대 4글자로 입력해주세요.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(BASE_MESSAGE, String.format(message));
    }

    public String getMessage() {
        return message;
    }
}
