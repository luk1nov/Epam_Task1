package lukyanov.task.arrays.filereader;

import lukyanov.task.arrays.customexception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileReader {
    private static final Logger logger = LogManager.getLogger(CustomFileReader.class);
    private static final String PATH = "resources/numbers.txt";

    public List<String> readFile() throws CustomException {
        File file = new File(PATH);

        try (BufferedReader reader = new BufferedReader(new FileReader(file)) ) {
            List<String> allLines = reader.lines().collect(Collectors.toList());
            logger.info("file in " + PATH + ":\n" + allLines);
            return allLines;
        } catch (IOException e) {
            logger.error("io exception");
            throw new CustomException(e.getMessage());
        }
    }

}
