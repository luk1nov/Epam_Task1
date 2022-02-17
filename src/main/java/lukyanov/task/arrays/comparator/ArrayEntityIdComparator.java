package lukyanov.task.arrays.comparator;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.lang.reflect.Array;
import java.util.Comparator;

public class ArrayEntityIdComparator implements Comparator<ArrayEntity> {

    @Override
    public int compare(ArrayEntity o1, ArrayEntity o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
