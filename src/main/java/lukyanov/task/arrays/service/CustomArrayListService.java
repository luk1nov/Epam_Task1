package lukyanov.task.arrays.service;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.parser.FileParser;
import lukyanov.task.arrays.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomArrayListService {
    private static final Logger logger = LogManager.getLogger();

    public List<ArrayEntity> getArraysFromFile(String path) throws CustomException {
        CustomFileReader cfs = new CustomFileReader();
        FileParser fileParser = new FileParser();
        List<String> stringList = cfs.readFile(path);
        return fileParser.parseFile(stringList);
    }
}
