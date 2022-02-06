package lukyanov.task.arrays.actions.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.service.ArrayEntityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayActionsImplTest {
    private ArrayEntity arrayEntity = new ArrayEntity();
    private final ArrayActionImpl action = new ArrayActionImpl();
    private static final Logger logger = LogManager.getLogger(ArraySortingImplTest.class);


    @BeforeEach
    @DisplayName("arrayServiceMethod")
    public void arrayServiceMethod() throws CustomException {
        ArrayEntityService aes = new ArrayEntityService();
        String path = "resources/file/numbers.txt";
        List<ArrayEntity> arrayEntityList = aes.getArrayFromFile(path);
        arrayEntity = arrayEntityList.get(0);
    }

    @Test
    @DisplayName("convertToIntStream")
    void convertToIntStreamTest() {
        IntStream intStream = action.convertToIntStream(arrayEntity);
        assertArrayEquals(intStream.toArray(), arrayEntity.getNumbers());
    }

    @Test
    @DisplayName("arrayMin")
    void getMinValue() {
        assertEquals(action.getMinValue(arrayEntity), -8);
    }

    @Test
    @DisplayName("arrayMax")
    void getMaxValue() {
        assertEquals(action.getMaxValue(arrayEntity), 3457);
    }

    @Test
    @DisplayName("arrayAvg")
    void getAvgValue() {
        assertEquals(action.getAvgValue(arrayEntity), 761);
    }

    @Test
    @DisplayName("arraySum")
    void getSummary() {
        assertEquals(action.getSummary(arrayEntity), 3805);
    }

    @Test
    @DisplayName("plusElements")
    void getNumberOfPlusElements() {
        assertEquals(action.getNumberOfPlusElements(arrayEntity), 4);
    }

    @Test
    @DisplayName("minusElements")
    void getNumberOfMinusElements() {
        assertEquals(action.getNumberOfMinusElements(arrayEntity), 1);
    }

    @Test
    @DisplayName("replaceElements")
    void replaceElement() {
        ArrayEntity expectedArrayEntity = new ArrayEntity(new int[]{28, 255, 3457, 73, 10});
        assertArrayEquals(action.replaceElement(arrayEntity, -8, 10).getNumbers(), expectedArrayEntity.getNumbers());
    }
}