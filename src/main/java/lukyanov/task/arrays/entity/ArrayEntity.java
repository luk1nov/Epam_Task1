package lukyanov.task.arrays.entity;

import java.util.List;

public class ArrayEntity {
    private List<Integer> numbers;

    public ArrayEntity(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArrayEntity{");
        stringBuilder.append("numbers=");
        stringBuilder.append(numbers);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
