package lukyanov.task.arrays.action.impl;

import lukyanov.task.arrays.action.ArrayAction;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.service.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayActionImpl implements ArrayAction {

    private static final Logger logger = LogManager.getLogger();
    private static ArrayActionImpl instance;

    private ArrayActionImpl() {
    }

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
    public Optional<Integer> findMinValue(ArrayEntity arrayEntity) {
        IntStream minimum = convertToIntStream(arrayEntity);
        OptionalInt result = minimum.min();
        return Optional.ofNullable(result.isPresent() ? result.getAsInt() : null);
    }

    @Override
    public Optional<Integer> findMaxValue(ArrayEntity arrayEntity) {
        IntStream maximum = convertToIntStream(arrayEntity);
        OptionalInt result = maximum.max();
        return Optional.ofNullable(result.isPresent() ? result.getAsInt() : null);
    }

    @Override
    public Optional<Double> findAvgValue(ArrayEntity arrayEntity) {
        IntStream avg = convertToIntStream(arrayEntity);
        OptionalDouble result = avg.average();
        return Optional.ofNullable(result.isPresent() ? result.getAsDouble() : null);
    }

    @Override
    public int findSum(ArrayEntity arrayEntity) {
        IntStream sum1 = convertToIntStream(arrayEntity);
        return sum1.sum();
    }

    @Override
    public long findPositiveElements(ArrayEntity arrayEntity) {
        IntStream plus = convertToIntStream(arrayEntity);
        return plus.filter(i -> (i > 0)).count();
    }

    @Override
    public long findNegativeElements(ArrayEntity arrayEntity) {
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
            if (i == desiredElement){
                i = newElement;
            }
            return i;
        });
        newArrayEntity = new ArrayEntity(IdGenerator.idGenerate(), minus.toArray());
        return newArrayEntity;
    }


    private void verifyBeforeAction(ArrayEntity arrayEntity) throws CustomException {
        if (arrayEntity == null) {
            logger.error("Array entity is null");
            throw new CustomException("Array entity is null");
        }

    }


}
