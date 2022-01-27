package lukyanov.task.arrays.sorting;

import lukyanov.task.arrays.entity.ArrayEntity;

public class ArraySorting {

    private void swap(int[] numbers, int ind1, int ind2) {
        int tmp = numbers[ind1];
        numbers[ind1] = numbers[ind2];
        numbers[ind2] = tmp;
    }

    public void bubbleSort(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[i - 1]) {
                    swap(numbers, i, i-1);
                    needIteration = true;
                }
            }
        }
    }



}
