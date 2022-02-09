package lukyanov.task.arrays.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class ArrayEntity {
    private static final Logger logger = LogManager.getLogger(ArrayEntity.class);
    private int[] numbers;

    public ArrayEntity() {

    }

    public ArrayEntity(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getLength(){
        return numbers.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ArrayEntity thisArray = (ArrayEntity) obj;
        return Arrays.equals(numbers, thisArray.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArrayEntity{");
        stringBuilder.append("numbers=");
        stringBuilder.append(Arrays.toString(numbers));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
