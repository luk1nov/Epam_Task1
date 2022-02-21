package lukyanov.task.arrays.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidationTest {
    private static final NumberValidation validation = NumberValidation.getInstance();

    @ParameterizedTest
    @ValueSource(strings = {"1;4;5", "1; 4; 5;", "34; 75; 22; 98; -5", ""})
    @DisplayName("validateValidLine")
    public void validateValidLine(String input) {
        assertTrue(validation.validateLine(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1w;4;5-", "2;we;643", "34; 75; 22s; 98; -5", "-5; 557; -58; -8:6"})
    @DisplayName("validateInvalidLine")
    public void validateInvalidLine(String input) {
        assertFalse(validation.validateLine(input));
    }

}