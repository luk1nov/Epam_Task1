package lukyanov.task.arrays.parser;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FileParserTest {
    private final FileParser fileParser = new FileParser();
    private static final Logger logger = LogManager.getLogger();
    private static final String PATH = "resources/file/numbers.txt";

    @Test
    public void parseFile() {
        try {
            int[] expectedArray = {28, 255, 3457, 73, -8};
            CustomFileReader customFileReader = new CustomFileReader();
            List<String> stringList = customFileReader.readFile(PATH);
            List<ArrayEntity> realArrayEntityList = fileParser.parseFile(stringList);
            assertArrayEquals(expectedArray, realArrayEntityList.get(0).getNumbers());
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}