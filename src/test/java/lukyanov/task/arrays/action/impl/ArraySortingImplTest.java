package lukyanov.task.arrays.action.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.service.CustomArrayListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortingImplTest {
    private final ArraySortingImpl sorting = ArraySortingImpl.getInstance();
    private static final Logger logger = LogManager.getLogger();
    private final int[] expectedArray = {-8, 28, 73, 255, 3457};
    private final ArrayEntity realArray = new ArrayEntity(1, new int[]{28, 255, 3457, 73, -8});


    @Test
    void bubbleSort() {
        assertArrayEquals(sorting.bubbleSort(realArray).getNumbers(), expectedArray );
    }

    @Test
    void selectionSort() {
        assertArrayEquals(sorting.selectionSort(realArray).getNumbers(), expectedArray );
    }

    @Test
    void insertionSort() {
        assertArrayEquals(sorting.insertionSort(realArray).getNumbers(), expectedArray );
    }
}