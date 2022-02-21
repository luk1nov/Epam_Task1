package lukyanov.task.arrays.comparator;

import lukyanov.task.arrays.entity.AbstractArrayEntity;

import java.util.Comparator;

public class ArrayEntityIdComparator implements Comparator<AbstractArrayEntity> {

    @Override
    public int compare(AbstractArrayEntity o1, AbstractArrayEntity o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
