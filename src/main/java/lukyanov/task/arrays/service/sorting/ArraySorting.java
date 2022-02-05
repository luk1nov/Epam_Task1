package lukyanov.task.arrays.service.sorting;

import lukyanov.task.arrays.entity.ArrayEntity;

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

    public void selectionSort(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            int minInd = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < numbers[minInd]) {
                    minInd = j;
                }
            }
            swap(numbers, i, minInd);
        }
    }

    public void insertionSort(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        for (int left = 0; left < numbers.length; left++) {
            // Вытаскиваем значение элемента
            int value = numbers[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < numbers[i]) {
                    numbers[i + 1] = numbers[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            numbers[i + 1] = value;
        }

    }


}
