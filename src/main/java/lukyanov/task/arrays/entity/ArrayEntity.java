package lukyanov.task.arrays.entity;

import java.util.Arrays;
import java.util.Collections;

public class ArrayEntity {
    private int[] numbers;

    public ArrayEntity() {

    }

    public ArrayEntity(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }

    public void setNumbers(int... numbers) {
        this.numbers = numbers;
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
