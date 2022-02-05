package lukyanov.task.arrays;

import lukyanov.task.arrays.customexception.CustomException;
import lukyanov.task.arrays.filereader.CustomFileReader;
import lukyanov.task.arrays.parser.FileReaderParser;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) throws CustomException {
        CustomFileReader customFileReader = new CustomFileReader();
        FileReaderParser fileReaderParser = new FileReaderParser();
        logger.info(fileReaderParser.parse(customFileReader.readFile()));
    }
}
