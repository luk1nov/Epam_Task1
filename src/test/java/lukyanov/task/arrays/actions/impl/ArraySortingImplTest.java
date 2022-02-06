package lukyanov.task.arrays.actions.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.service.ArrayEntityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortingImplTest {
    private ArrayEntity arrayEntity = new ArrayEntity();
    private final ArraySortingImpl sorting = new ArraySortingImpl();
    private static final Logger logger = LogManager.getLogger(ArraySortingImplTest.class);
    private static final int[] expectedArrayNumbers = {-8, 28, 73, 255, 3457};


    @BeforeEach
    @DisplayName("arrayServiceMethod")
    public void arrayServiceMethod() throws CustomException {
        ArrayEntityService aes = new ArrayEntityService();
        String path = "resources/file/numbers.txt";
        List<ArrayEntity> arrayEntityList = aes.getArrayFromFile(path);
        arrayEntity = arrayEntityList.get(0);
    }

    @Test
    @DisplayName("bubbleSort")
    void bubbleSort() {
        assertArrayEquals(sorting.bubbleSort(arrayEntity).getNumbers(), expectedArrayNumbers);
    }

    @Test
    @DisplayName("selectionSort")
    void selectionSort() {
        assertArrayEquals(sorting.selectionSort(arrayEntity).getNumbers(), expectedArrayNumbers);
    }

    @Test
    @DisplayName("insertionSort")
    void insertionSort() {
        assertArrayEquals(sorting.insertionSort(arrayEntity).getNumbers(), expectedArrayNumbers);
    }
}