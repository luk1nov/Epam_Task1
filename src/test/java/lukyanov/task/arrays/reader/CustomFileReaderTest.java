package lukyanov.task.arrays.reader;

import lukyanov.task.arrays.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest {
    private final CustomFileReader customFileReader = new CustomFileReader();
    private static final Logger logger = LogManager.getLogger();
    private static final String PATH = "resources/file/numbers.txt";

    @Test
    void readFile() {
        try {
            List<String> readStringList = customFileReader.readFile(PATH);
            String expectedString = "28; 255; 3457; 73; -8";
            assertEquals(readStringList.get(0).strip(), expectedString);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}