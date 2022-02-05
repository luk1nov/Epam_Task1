package lukyanov.task.arrays.parser;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.validation.NumberValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {
    private static final Logger logger = LogManager.getLogger(FileParser.class);

    public List<ArrayEntity> parseFile(List<String> lines){
        List<ArrayEntity> arrayEntityList = new ArrayList<>();
        for (String line : lines) {
            if (NumberValidation.checkWholeString(line)){
                arrayEntityList.add(parseLine(line));
                logger.info("Valid line");
            } else {
                logger.error("Invalid line");
            }
        }
        return arrayEntityList;
    }


    private ArrayEntity parseLine(String line){
        ArrayEntity arrayEntity;
        List<String> splitArray = Arrays.asList(line.split(";"));
        int[] array = new int[splitArray.size()];
        for (int i = 0; i < splitArray.size(); i++) {
            array[i] = Integer.parseInt(splitArray.get(i).trim());
        }
        arrayEntity = new ArrayEntity(array);
        logger.info(Arrays.toString(array) + " parsed");
        return arrayEntity;
    }
}
