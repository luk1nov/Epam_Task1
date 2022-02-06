package lukyanov.task.arrays.validation;

import lukyanov.task.arrays.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidationTest {

    @Test
    public void validateLine() throws CustomException {
        assertTrue(NumberValidation.validateLine("1;4;5"));
        assertTrue(NumberValidation.validateLine("1; 4; 5;"));
        assertFalse(NumberValidation.validateLine("1 ; 4d ; 5;"));
    }

}