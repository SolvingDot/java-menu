package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {
    @Test
    void name() {
    }
    @DisplayName("빈칸, "
            + "빈 이름, "
            + "이름 개수 2명 미만 5명 초과, "
            + "이름에 띄어쓰기, "
            + "이름 2글자 미만 4글자 초과 -> 예외 발생 (예외 메시지는 '[ERROR]'로 시작)")
    @ValueSource(strings = {"",
            "포비,왼손,제이슨,", "포비,,왼손",
            "포비", "포비,왼손,오른손,제이슨,제로,콜라",
            "포 비,왼 손",
            "포,비,왼,손", "아이스크림,초코누텔라,안드로이드"})
    @ParameterizedTest
    void 예외_발생_테스트(String input) {
        // Given
        Coach coach = new Coach();

        // When, Then
        assertThatThrownBy(() -> coach.readNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("입력을 쉼표 단위로 나누어 각 이름들을 리스트에 저장")
    @Test
    void 기능_테스트() {
        // Given
        Coach coach = new Coach();

        // When
        List<String> names = coach.readNames("포비,왼손,제이슨");

        // Then
        assertThat(names).isEqualTo(List.of("포비", "왼손", "제이슨"));
    }
}