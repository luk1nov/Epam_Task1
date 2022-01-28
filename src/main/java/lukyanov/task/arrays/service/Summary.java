package lukyanov.task.arrays.service;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Summary {

    public IntStream convertToIntStream(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        return Arrays.stream(numbers);
    }

    public int getMinValue(ArrayEntity arrayEntity){
        IntStream minimum = convertToIntStream(arrayEntity);
        OptionalInt min1 = minimum.min();
        return min1.getAsInt();
    }

    public int getMaxValue(ArrayEntity arrayEntity){
        IntStream maximum = convertToIntStream(arrayEntity);
        OptionalInt min1 = maximum.min();
        return min1.getAsInt();
    }

    public double getAvgValue(ArrayEntity arrayEntity){
        IntStream avg = convertToIntStream(arrayEntity);
        OptionalDouble avg1 = avg.average();
        return avg1.getAsDouble();
    }

    public int getSummary(ArrayEntity arrayEntity){
        IntStream sum1 = convertToIntStream(arrayEntity);
        return sum1.sum();
    }

    public long getNumberOfPlusElements(ArrayEntity arrayEntity){
        IntStream plus = convertToIntStream(arrayEntity);
        return plus.filter(i -> (i > 0)).count();
    }

    public long getNumberOfMinusElements(ArrayEntity arrayEntity){
        IntStream minus = convertToIntStream(arrayEntity);
        return minus.filter(i -> (i < 0)).count();
    }

    public int[] replaceElement(ArrayEntity arrayEntity, int desiredElement, int newElement){
        int[] numbers = arrayEntity.getNumbers();
        IntStream minus = IntStream.of(numbers).map(i -> {
           if (i == desiredElement) i = newElement;
            return i;
        });
        return minus.toArray();
    }
}
