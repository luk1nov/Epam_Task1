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
    private static final Logger logger = LogManager.getLogger(ArraySortingImplTest.class);
    private static final int[] expectedArrayNumbers = {-8, 28, 73, 255, 3457};
    private ArrayEntity arrayEntity = new ArrayEntity();


    @BeforeEach
    @DisplayName("arrayServiceMethod")
    public void arrayServiceMethod() throws CustomException {
        CustomArrayListService aes = new CustomArrayListService();
        String path = "resources/file/numbers.txt";
        List<ArrayEntity> arrayEntityList = aes.getArrayFromFile(path);
        arrayEntity = arrayEntityList.get(0);
    }

    @Test
    @DisplayName("bubbleSort")
    void bubbleSort() {
        assertArrayEquals(expectedArrayNumbers, sorting.bubbleSort(arrayEntity).getNumbers() );
    }

    @Test
    @DisplayName("selectionSort")
    void selectionSort() {
        assertArrayEquals(expectedArrayNumbers, sorting.selectionSort(arrayEntity).getNumbers());
    }

    @Test
    @DisplayName("insertionSort")
    void insertionSort() {
        assertArrayEquals(expectedArrayNumbers, sorting.insertionSort(arrayEntity).getNumbers());
    }
}