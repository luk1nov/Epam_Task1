package lukyanov.task.arrays.reader;

import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.validation.NumberValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readFile(String path) throws CustomException {
        List<String> list;
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file)) ) {
            list = reader.lines().filter(NumberValidation::validateLine).collect(Collectors.toList());
            return list;
        } catch (FileNotFoundException ex) {
            logger.error("File " + path +" is not found", ex.getMessage());
            throw new CustomException(ex);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

}
