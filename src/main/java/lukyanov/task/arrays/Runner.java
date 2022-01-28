package lukyanov.task.arrays;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.service.Summary;
import lukyanov.task.arrays.sorting.ArraySorting;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        int[] start = {0, 10, -1, -2, 8, 6};
        Summary summary = new Summary();
        ArrayEntity arrayEntity = new ArrayEntity(start);
        ArraySorting arraySorting = new ArraySorting();
        logger.info(arrayEntity);
        arraySorting.bubbleSort(arrayEntity);
        logger.info(arrayEntity);
    }
}
