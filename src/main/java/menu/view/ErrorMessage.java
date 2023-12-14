package menu.view;

public enum ErrorMessage {
    EMPTY_INPUT("아무 입력이 없습니다."),
    COMMA_PLACE("쉼표는 이름(또는 메뉴)을 구분할 때만 사용해주세요."),
    NUMBER_OF_NAMES("코치는 최소 2명, 최대 5명을 입력해주세요."),
    SPACE("이름은 띄어쓰지 말고 입력해주세요."),
    LENGTH_OF_NAME("이름은 최소 2글자, 최대 4글자로 입력해주세요."),
    FOOD_OUT_OF_MENU("메뉴에 있는 음식을 입력해주세요."),
    MISMATCH_NUMBER("숫자와 일치하는 카테고리가 없습니다."),
    MISMATCH_CATEGORY("일치하는 카테고리가 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(BASE_MESSAGE, String.format(message));
    }

    public String getMessage() {
        return message;
    }
}
