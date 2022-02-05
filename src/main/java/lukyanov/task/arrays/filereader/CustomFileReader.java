package lukyanov.task.arrays.filereader;

import lukyanov.task.arrays.customexception.CustomException;
import lukyanov.task.arrays.entity.ArrayEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {

    private final String path = "resources/numbers.txt";

    public List<String> readFile() throws CustomException {
        File file = new File(path);

        try (FileReader fr = new FileReader(file)) {
            List<ArrayEntity> arrayEntityList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(fr);
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new CustomException(e.getMessage());
        }
    }

}
