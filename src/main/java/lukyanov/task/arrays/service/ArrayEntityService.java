package lukyanov.task.arrays.service;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.parser.FileParser;
import lukyanov.task.arrays.reader.CustomFileReader;

import java.util.List;

public class ArrayEntityService {

    public List<ArrayEntity> getArrayFromFile(String path) throws CustomException {
        CustomFileReader cfs = new CustomFileReader();
        FileParser fileParser = new FileParser();
        List<String> stringList = cfs.readFile(path);
        return fileParser.parseFile(stringList);
    }
}
