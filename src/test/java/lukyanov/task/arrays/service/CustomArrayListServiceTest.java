package lukyanov.task.arrays.service;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListServiceTest {

    private final CustomArrayListService aes = new CustomArrayListService();
    private final int[] expectedArray = {28, 255, 3457, 73, -8};
    private static final String PATH = "resources/file/numbers.txt";
    private static final Logger logger = LogManager.getLogger();

    @Test
    @DisplayName("getArrayFromFile")
    void getArrayFromFile() {
        try {
            List<ArrayEntity> readArrayEntityList = aes.getArrayFromFile(PATH);
            assertArrayEquals(expectedArray, readArrayEntityList.get(0).getNumbers());
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}