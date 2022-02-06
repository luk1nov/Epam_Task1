package lukyanov.task.arrays.reader;

import lukyanov.task.arrays.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileReader {
    private static final Logger logger = LogManager.getLogger(CustomFileReader.class);

    public List<String> readFile(String path) throws CustomException {
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file)) ) {
            return reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new CustomException("File is not found", e);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

}
