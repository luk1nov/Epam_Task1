package lukyanov.task.arrays.action.impl;

import lukyanov.task.arrays.action.ArrayAction;
import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayActionImpl implements ArrayAction {

    public IntStream convertToIntStream(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        return Arrays.stream(numbers);
    }

    @Override
    public int getMinValue(ArrayEntity arrayEntity) {
        IntStream minimum = convertToIntStream(arrayEntity);
        OptionalInt min1 = minimum.min();
        return min1.getAsInt();
    }

    @Override
    public int getMaxValue(ArrayEntity arrayEntity) {
        IntStream maximum = convertToIntStream(arrayEntity);
        OptionalInt max1 = maximum.max();
        return max1.getAsInt();
    }

    @Override
    public double getAvgValue(ArrayEntity arrayEntity) {
        IntStream avg = convertToIntStream(arrayEntity);
        OptionalDouble avg1 = avg.average();
        return avg1.getAsDouble();
    }

    @Override
    public int getSummary(ArrayEntity arrayEntity) {
        IntStream sum1 = convertToIntStream(arrayEntity);
        return sum1.sum();
    }

    @Override
    public long getNumberOfPlusElements(ArrayEntity arrayEntity) {
        IntStream plus = convertToIntStream(arrayEntity);
        return plus.filter(i -> (i > 0)).count();
    }

    @Override
    public long getNumberOfMinusElements(ArrayEntity arrayEntity) {
        IntStream minus = convertToIntStream(arrayEntity);
        return minus.filter(i -> (i < 0)).count();
    }

    @Override
    public ArrayEntity replaceElement(ArrayEntity arrayEntity, int desiredElement, int newElement) {
        ArrayEntity newArrayEntity;
        int[] numbers = arrayEntity.getNumbers();
        IntStream minus = IntStream.of(numbers).map(i -> {
            if (i == desiredElement) i = newElement;
            return i;
        });
        newArrayEntity = new ArrayEntity(minus.toArray());
        return newArrayEntity;
    }
}
