package lukyanov.task.arrays.sorting;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.Arrays;
import java.util.List;

public class ArraySorting {

    private void swap(List<Integer> numbers, int ind1, int ind2) {
        Integer tmp = numbers.get(ind1);
        numbers.set(ind1, numbers.get(ind2));
        numbers.set(ind2, tmp);
    }

    public void bubbleSort(ArrayEntity arrayEntity){
        List<Integer> numbers = arrayEntity.getNumbers();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(i) < numbers.get(i - 1)) {
                    swap(numbers, i, i-1);
                    needIteration = true;
                }
            }
        }
    }

}
