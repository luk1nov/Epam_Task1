package lukyanov.task.arrays.comparator;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEntityNumbersComparator implements Comparator<ArrayEntity> {
    @Override
    public int compare(ArrayEntity o1, ArrayEntity o2) {
        return Arrays.compare(o1.getNumbers(), o2.getNumbers());
    }
}
