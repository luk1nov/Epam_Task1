package lukyanov.task.arrays.repository;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {

    boolean addArray(ArrayEntity arrayEntity);

    boolean addAllArrays(List<ArrayEntity> arrayEntities);

    boolean removeArray(ArrayEntity arrayEntity);

    boolean removeAllArrays(List<ArrayEntity> arrayEntities);

    ArrayEntity get(int index);

    ArrayEntity set(int index, ArrayEntity arrayEntity);

    List<ArrayEntity> query(Specification specification );

    List<ArrayEntity> sort(Comparator<? super ArrayEntity> comparator);
}
