package lukyanov.task.arrays.action;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.Optional;

public interface ArrayAction {

    Optional<Integer> findMinValue(ArrayEntity arrayEntity);

    Optional<Integer> findMaxValue(ArrayEntity arrayEntity);

    Optional<Double> findAvgValue(ArrayEntity arrayEntity);

    int findSum(ArrayEntity arrayEntity);

    long findPositiveElements(ArrayEntity arrayEntity);

    long findNegativeElements(ArrayEntity arrayEntity);

    ArrayEntity replaceElement(ArrayEntity arrayEntity, int desiredElement, int newElement);
}
