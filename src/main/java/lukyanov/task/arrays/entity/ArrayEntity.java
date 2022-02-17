package lukyanov.task.arrays.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayEntity extends AbstractArrayEntity {
    private static final Logger logger = LogManager.getLogger();
    private int[] numbers;


    public ArrayEntity() {
        super();
    }

    public ArrayEntity(long id, int[] numbers) {
        super(id);
        this.numbers = numbers.clone();
    }

    public int[] getNumbers() {
        return numbers.clone();
    }

    public void setNumbers(int... numbers) {
        this.numbers = numbers.clone();
        notifyObserver();
    }

    public int getLength(){
        return numbers.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ArrayEntity array = (ArrayEntity) o;
        return Arrays.equals(numbers, array.numbers);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(numbers);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArrayEntity{");
        stringBuilder.append("id=");
        stringBuilder.append(this.getId());
        stringBuilder.append("; ");
        stringBuilder.append("numbers=");
        stringBuilder.append(Arrays.toString(numbers));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
