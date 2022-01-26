package service;

import entity.ArrayEntity;

public class Summary {

    public int getMinValue(ArrayEntity arrayEntity){
        int min = arrayEntity.getFirstElement();
        for (int i: arrayEntity.getArray()) {
            if(i < min) min = i;
        }
        return min;
    }

    public int getMaxValue(ArrayEntity arrayEntity){
        int max = arrayEntity.getFirstElement();
        for (int i: arrayEntity.getArray()) {
            if(i > max) max = i;
        }
        return max;
    }

    public float getAvgValue(ArrayEntity arrayEntity){
        float amountOfItems = 0;
        int summary;
        float avg;
        for (int i: arrayEntity.getArray()) {
            amountOfItems++;
        }
        summary = getSummary(arrayEntity);
        avg = summary/amountOfItems;
        return avg;
    }

    public int getSummary(ArrayEntity arrayEntity){
        int summary = 0;
        for (int i: arrayEntity.getArray()) {
            summary += i;
        }
        return summary;
    }

    public int getNumberOfPlusElements(ArrayEntity arrayEntity){
        int plus = 0;
        for (int i: arrayEntity.getArray()) {
            if (i > 0) plus++;
        }
        return plus;
    }

    public int getNumberOfMinusElements(ArrayEntity arrayEntity){
        int minus = 0;
        for (int i: arrayEntity.getArray()) {
            if (i < 0) minus++;
        }
        return minus;
    }

    public void replaceElement(ArrayEntity arrayEntity, int desiredElement, int newElement){
        int arrayLength = arrayEntity.getSize();
        int[] array = arrayEntity.getArray();
        for (int i = 0; i < arrayLength; i++){
            if (array[i] == desiredElement){
                array[i] = newElement;
            }
        }
    }
}
