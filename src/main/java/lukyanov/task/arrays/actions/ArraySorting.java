package lukyanov.task.arrays.actions;

import lukyanov.task.arrays.entity.ArrayEntity;

public interface ArraySorting {

    ArrayEntity bubbleSort(ArrayEntity arrayEntity);

    ArrayEntity selectionSort(ArrayEntity arrayEntity);

    ArrayEntity insertionSort(ArrayEntity arrayEntity);
}
