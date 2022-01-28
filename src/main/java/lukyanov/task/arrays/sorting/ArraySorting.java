package lukyanov.task.arrays.sorting;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraySorting {

    static private boolean needSorting = true;

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

//    public void newbubbleSort(ArrayEntity arrayEntity){
//        int[] numbers = arrayEntity.getNumbers();
//        while (needSorting) {
//            needSorting = false;
//            IntStream.range(0, numbers.length - 1).forEach(i -> {
//                if (numbers[i] > numbers[i + 1]) {
//                    swap(numbers, i, i+1);
//                    needSorting = true;
//                }
//            });
//        }
//    }

}
