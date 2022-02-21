package lukyanov.task.arrays.action.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.service.CustomArrayListService;
import lukyanov.task.arrays.service.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayActionImplTest {
    private final ArrayActionImpl action = ArrayActionImpl.getInstance();
    private static final Logger logger = LogManager.getLogger();
    private ArrayEntity arrayEntity = new ArrayEntity();

    @BeforeEach
    void setUp() throws CustomException {
        CustomArrayListService aes = new CustomArrayListService();
        String path = "resources/file/numbers.txt";
        List<ArrayEntity> arrayEntityList = aes.getArrayFromFile(path);
        arrayEntity = arrayEntityList.get(0);
    }

    @Test
    void convertToIntStreamTest() {
        IntStream intStream = action.convertToIntStream(arrayEntity);
        assertArrayEquals(intStream.toArray(), arrayEntity.getNumbers());
    }

    @Test
    void findMinValue() {
        Optional<Integer> expectedMin = Optional.of(-8);
        assertEquals(action.findMinValue(arrayEntity), expectedMin);
    }

    @Test
    void findMaxValue() {
        Optional<Integer> expectedMax = Optional.of(3457);
        assertEquals(action.findMaxValue(arrayEntity), expectedMax);
    }

    @Test
    void findAvgValue() {
        Optional<Double> expectedAvg = Optional.of(761.0);
        assertEquals(action.findAvgValue(arrayEntity), expectedAvg);
    }

    @Test
    void findSum() {
        int expectedSum = 3805;
        assertEquals(action.findSum(arrayEntity), expectedSum);
    }

    @Test
    void findPositiveElements() {
        int expectedPositive = 4;
        assertEquals(action.findPositiveElements(arrayEntity), expectedPositive);
    }

    @Test
    void findNegativeElements() {
        int expectedNegative = 1;
        assertEquals(action.findNegativeElements(arrayEntity), expectedNegative);
    }

    @Test
    void replaceElement() {
        ArrayEntity expectedArrayEntity = new ArrayEntity(IdGenerator.idGenerate(), new int[]{28, 255, 3457, 73, 10});
        assertArrayEquals(expectedArrayEntity.getNumbers(), action.replaceElement(arrayEntity, -8, 10).getNumbers());
    }
}