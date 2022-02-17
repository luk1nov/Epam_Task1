package lukyanov.task.arrays.entity;

import lukyanov.task.arrays.observer.ArrayEvent;
import lukyanov.task.arrays.observer.ArrayObservable;
import lukyanov.task.arrays.observer.ArrayObserver;
import lukyanov.task.arrays.observer.impl.ArrayObserverImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


/*    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ArrayEntity thisArray = (ArrayEntity) obj;
        return Arrays.equals(numbers, thisArray.numbers) && thisArray.getId() == this.getId();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayEntity array = (ArrayEntity) o;
        return Arrays.equals(numbers, array.numbers);
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
