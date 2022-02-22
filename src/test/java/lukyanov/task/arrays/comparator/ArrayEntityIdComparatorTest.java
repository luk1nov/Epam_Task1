package lukyanov.task.arrays.comparator;

import lukyanov.task.arrays.entity.AbstractArrayEntity;
import lukyanov.task.arrays.entity.ArrayEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayEntityIdComparatorTest {
    private final ArrayEntityIdComparator idComparator = new ArrayEntityIdComparator();

    @Test
    public void compare() {
        long expectedCompare = 0;
        AbstractArrayEntity firstArray = new ArrayEntity(15, new int[]{});
        AbstractArrayEntity secondArray = new ArrayEntity(15, new int[]{1,2,3});
        assertEquals(idComparator.compare(firstArray, secondArray), expectedCompare);
    }
}