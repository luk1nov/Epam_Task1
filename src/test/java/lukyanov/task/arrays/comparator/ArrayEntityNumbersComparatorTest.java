package lukyanov.task.arrays.comparator;

import lukyanov.task.arrays.entity.ArrayEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayEntityNumbersComparatorTest {
    private final ArrayEntityNumbersComparator numbersComparator = new ArrayEntityNumbersComparator();

    @Test
    public void compare() {
        long expectedCompare = 0;
        ArrayEntity firstArray = new ArrayEntity(15, new int[]{4, 5, 6});
        ArrayEntity secondArray = new ArrayEntity(15, new int[]{4, 5, 6});
        assertEquals(numbersComparator.compare(firstArray, secondArray), expectedCompare);
    }
}