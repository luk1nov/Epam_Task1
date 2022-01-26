package lukyanov.task.arrays;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.service.Summary;
import lukyanov.task.arrays.sorting.ArraySorting;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        Integer[] a = {1, -2, 6, 4, 8, 10};
        List<Integer> array = Arrays.asList(a);
        ArrayEntity arrayEntity = new ArrayEntity(array);
        ArraySorting arraySorting = new ArraySorting();
        logger.info(arrayEntity);
        arraySorting.bubbleSort(arrayEntity);
        logger.info(arrayEntity);
    }
}
