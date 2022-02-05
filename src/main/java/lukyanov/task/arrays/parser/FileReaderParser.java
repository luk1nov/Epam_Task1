package lukyanov.task.arrays.parser;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.validation.NumberValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileReaderParser {
    public List<ArrayEntity> parse(List<String> lines){
        List<ArrayEntity> arrayEntityList = new ArrayList<>();
        for (String line : lines) {
            if (NumberValidation.checkWholeString(line)){
                arrayEntityList.add(parseLine(line));
            }
        }
        return arrayEntityList;
    }


    private ArrayEntity parseLine(String line){
        List<String> splitArray = Arrays.asList(line.split(";"));
        int[] array = new int[splitArray.size()];
        for (int i = 0; i < splitArray.size(); i++) {
            array[i] = Integer.parseInt(splitArray.get(i).trim());
        }
        return new ArrayEntity(array);
    }
}
