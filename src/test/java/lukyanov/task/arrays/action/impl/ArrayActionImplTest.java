package lukyanov.task.arrays.action.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.service.CustomArrayListService;
import lukyanov.task.arrays.service.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayActionImplTest {
    private final ArrayActionImpl action = ArrayActionImpl.getInstance();
    private static final Logger logger = LogManager.getLogger(ArraySortingImplTest.class);
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
    @DisplayName("convertToIntStream")
    void convertToIntStreamTest() {
        IntStream intStream = action.convertToIntStream(arrayEntity);
        assertArrayEquals(intStream.toArray(), arrayEntity.getNumbers());
    }

    @Test
    @DisplayName("arrayMin")
    void getMinValue() {
        assertEquals(OptionalInt.of(-8), action.getMinValue(arrayEntity));
    }

    @Test
    @DisplayName("arrayMax")
    void getMaxValue() {
        assertEquals( OptionalInt.of(3457), action.getMaxValue(arrayEntity));
    }

    @Test
    @DisplayName("arrayAvg")
    void getAvgValue() {
        assertEquals(OptionalDouble.of(761), action.getAvgValue(arrayEntity));
    }

    @Test
    @DisplayName("arraySum")
    void getSummary() {
        assertEquals(3805, action.getSummary(arrayEntity));
    }

    @Test
    @DisplayName("plusElements")
    void getNumberOfPlusElements() {
        assertEquals(4, action.getNumberOfPlusElements(arrayEntity));
    }

    @Test
    @DisplayName("minusElements")
    void getNumberOfMinusElements() {
        assertEquals(1, action.getNumberOfMinusElements(arrayEntity));
    }

    @Test
    @DisplayName("replaceElements")
    void replaceElement() {
        ArrayEntity expectedArrayEntity = new ArrayEntity(IdGenerator.idGenerate(), new int[]{28, 255, 3457, 73, 10});
        assertArrayEquals(expectedArrayEntity.getNumbers(), action.replaceElement(arrayEntity, -8, 10).getNumbers());
    }
}