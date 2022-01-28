package lukyanov.task.arrays;

import lukyanov.task.arrays.customexception.CustomException;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.filereader.CustomFileReader;
import lukyanov.task.arrays.service.Summary;
import lukyanov.task.arrays.sorting.ArraySorting;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) throws CustomException {
        int[] start = {0, 10, -1, -2, 8, 6};
        ArrayEntity arrayEntity = new ArrayEntity(start);
        CustomFileReader customFileReader = new CustomFileReader();
        customFileReader.readFile();
    }
}
