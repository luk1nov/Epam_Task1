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
            if (NumberValidation.validateLine(line)){
                logger.info("[" + line + "] Valid line");
                arrayEntityList.add(parseLine(line));
            } else {
                logger.error("[" + line + "] Invalid line");
            }
        }
        return arrayEntityList;
    }


    private ArrayEntity parseLine(String line){
        ArrayEntity arrayEntity;
        List<String> splitArray = Arrays.asList(line.split(";"));
        arrayEntity = new ArrayEntity(parseToArray(splitArray));
        logger.info("entity parsed " + arrayEntity);
        return arrayEntity;
    }

    private static int[] parseToArray(List<String> list){
        if(list.size() == 1 && list.get(0).trim().isEmpty()){
            return new int[0];
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = Integer.parseInt(list.get(i).trim());
        }
        return array;
    }
}
