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
    private static final Logger logger = LogManager.getLogger(CustomFileReaderTest.class);
    private static final String PATH = "resources/file/numbers.txt";
    private final CustomFileReader customFileReader = new CustomFileReader();

    @Test
    @DisplayName("readFile")
    void readFile() {
        try {
            List<String> readStringList = customFileReader.readFile(PATH);
            List<String> expectedStringList = new ArrayList<>();

            expectedStringList.add("28; 255; 3457; 73; -8");
            expectedStringList.add("2;we;643");

            assertEquals(readStringList.get(0).trim(), expectedStringList.get(0));
            assertEquals(readStringList.get(2).trim(), expectedStringList.get(1));
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}