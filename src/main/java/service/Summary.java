package service;

import entity.ArrayEntity;

public class Summary {

    public int findMinValue(ArrayEntity arrayEntity){
        int min = arrayEntity.getFirstElement();
        for (int i: arrayEntity.getArray()) {
            if(i < min) min = i;
        }
        return min;
    }

    public int findMaxValue(ArrayEntity arrayEntity){
        int max = arrayEntity.getFirstElement();
        for (int i: arrayEntity.getArray()) {
            if(i > max) max = i;
        }
        return max;
    }
}
