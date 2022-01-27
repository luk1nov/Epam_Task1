package lukyanov.task.arrays.service;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Summary {

    public int getMinValue(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        IntStream minimum = IntStream.of(numbers);
        OptionalInt min1 = minimum.min();
        int min2 = min1.getAsInt();
        return min2;
    }

    public int getMaxValue(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        IntStream maximum = IntStream.of(numbers);
        OptionalInt max1 = maximum.max();
        int max2 = max1.getAsInt();
        return max2;
    }

    public double getAvgValue(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        IntStream avg = IntStream.of(numbers);
        OptionalDouble avg1 = avg.average();
        double avg2 = avg1.getAsDouble();
        return avg2;
    }

    public int getSummary(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        IntStream sum1 = IntStream.of(numbers);
        int sum2 = sum1.sum();
        return sum2;
    }

    public long getNumberOfPlusElements(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        IntStream plus = IntStream.of(numbers);
        plus = plus.filter(i -> (i > 0));
        return plus.count();
    }

    public long getNumberOfMinusElements(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        IntStream minus = Arrays.stream(numbers);
        minus = minus.filter(i -> (i < 0));
        return minus.count();
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
