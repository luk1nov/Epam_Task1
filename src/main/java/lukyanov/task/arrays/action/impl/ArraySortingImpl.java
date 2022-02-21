package lukyanov.task.arrays.action.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.action.ArraySorting;
import lukyanov.task.arrays.service.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortingImpl implements ArraySorting {
    private static final Logger logger = LogManager.getLogger();
    private static ArraySortingImpl instance;

    private ArraySortingImpl() {
    }

    public static ArraySortingImpl getInstance(){
        if(instance == null){
            instance = new ArraySortingImpl();
        }
        return instance;
    }

    private void swap(int[] numbers, int ind1, int ind2) {
        int tmp = numbers[ind1];
        numbers[ind1] = numbers[ind2];
        numbers[ind2] = tmp;
    }

    @Override
    public ArrayEntity bubbleSort(ArrayEntity arrayEntity){
        ArrayEntity sortedArrayEntity;
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
        sortedArrayEntity = new ArrayEntity(IdGenerator.idGenerate(), numbers);
        return sortedArrayEntity;
    }

    @Override
    public ArrayEntity selectionSort(ArrayEntity arrayEntity){
        ArrayEntity newArrayEntity;
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
        newArrayEntity = new ArrayEntity(IdGenerator.idGenerate(), numbers);
        return newArrayEntity;
    }

    @Override
    public ArrayEntity insertionSort(ArrayEntity arrayEntity){
        ArrayEntity newArrayEntity;
        int[] numbers = arrayEntity.getNumbers();
        for (int left = 0; left < numbers.length; left++) {
            int value = numbers[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < numbers[i]) {
                    numbers[i + 1] = numbers[i];
                } else {
                    break;
                }
            }
            numbers[i + 1] = value;
        }
        newArrayEntity = new ArrayEntity(IdGenerator.idGenerate(), numbers);
        return newArrayEntity;
    }


}
