package lukyanov.task.arrays.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"1;4;5", "1; 4; 5;"})
    @DisplayName("validateValidLine")
    void validateValidLine(String input) {
        assertTrue(NumberValidation.validateLine(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1w;4;5-", "2;we;643"})
    @DisplayName("validateInvalidLine")
    void validateInvalidLine(String input) {
        assertFalse(NumberValidation.validateLine(input));
    }

}