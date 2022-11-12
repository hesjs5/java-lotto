package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("구매금액이 금액단위를 따르는지 여부 반환 - 따르지 않음")
    @Test
    void validateUnitStandardNotFollow() {
        // given
        int purchaseAmount = 8_001;

        // expected
        assertThatThrownBy(() -> Validator.validateUnitStandard(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 금액단위를 따르는지 여부 반환 - 따름")
    @Test
    void validateUnitStandardFollow() {
        // given
        int purchaseAmount = 8_000;

        // expected
        Validator.validateUnitStandard(purchaseAmount);
    }

    @DisplayName("당첨 번호 개수를 6개 입력했는지 확인 - 따르지 않음")
    @Test
    void validatePlayNumbersCountNotFollow() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5);

        // expected
        assertThatThrownBy(() -> Validator.validatePlayNumbersCount(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 개수를 6개 입력했는지 확인 - 따름")
    @Test
    void validatePlayNumbersCountFollow() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 6);

        // expected
        Validator.validatePlayNumbersCount(playerNumbers);
    }
}