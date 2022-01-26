package lukyanov.task.arrays.service;

import lukyanov.task.arrays.entity.ArrayEntity;
import java.util.List;

public class Summary {

    public int getMinValue(ArrayEntity arrayEntity){
        List<Integer> numbers = arrayEntity.getNumbers();
        int min = numbers.get(0);
        for (int i: numbers) {
            if(i < min) min = i;
        }
        return min;
    }

    public int getMaxValue(ArrayEntity arrayEntity){
        List<Integer> numbers = arrayEntity.getNumbers();
        int max = numbers.get(0);
        for (int i: numbers) {
            if(i > max) max = i;
        }
        return max;
    }

    public float getAvgValue(ArrayEntity arrayEntity){
        float amountOfItems = 0;
        int summary;
        float avg;
        for (int i: arrayEntity.getNumbers()) {
            amountOfItems++;
        }
        summary = getSummary(arrayEntity);
        avg = summary/amountOfItems;
        return avg;
    }

    public int getSummary(ArrayEntity arrayEntity){
        int summary = 0;
        for (int i: arrayEntity.getNumbers()) {
            summary += i;
        }
        return summary;
    }

    public int getNumberOfPlusElements(ArrayEntity arrayEntity){
        int plus = 0;
        for (int i: arrayEntity.getNumbers()) {
            if (i > 0) plus++;
        }
        return plus;
    }

    public int getNumberOfMinusElements(ArrayEntity arrayEntity){
        int minus = 0;
        for (int i: arrayEntity.getNumbers()) {
            if (i < 0) minus++;
        }
        return minus;
    }

    public List<Integer> replaceElement(ArrayEntity arrayEntity, int desiredElement, int newElement){
        List<Integer> numbers = arrayEntity.getNumbers();
        int arrayLength = arrayEntity.getNumbers().size();
        for (int i = 0; i < arrayLength; i++){
            if (numbers.get(i) == desiredElement){
                numbers.set(i, newElement);
            }
        }
        return numbers;
    }
}
