package lukyanov.task.arrays.action.impl;

import lukyanov.task.arrays.action.ArrayAction;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.entity.Warehouse;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayActionImpl implements ArrayAction {

    private static ArrayActionImpl instance;

    public static ArrayActionImpl getInstance(){
        if(instance == null){
            instance = new ArrayActionImpl();
        }
        return instance;
    }


    public IntStream convertToIntStream(ArrayEntity arrayEntity){
        int[] numbers = arrayEntity.getNumbers();
        return Arrays.stream(numbers);
    }

    @Override
    public OptionalInt getMinValue(ArrayEntity arrayEntity) {
        IntStream minimum = convertToIntStream(arrayEntity);
        return minimum.min();
    }

    @Override
    public OptionalInt getMaxValue(ArrayEntity arrayEntity) {
        IntStream maximum = convertToIntStream(arrayEntity);
        return maximum.max();
    }

    @Override
    public OptionalDouble getAvgValue(ArrayEntity arrayEntity) {
        IntStream avg = convertToIntStream(arrayEntity);
        return avg.average();
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
        if (arrayEntity.getLength() == 0){
            return arrayEntity;
        }
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
