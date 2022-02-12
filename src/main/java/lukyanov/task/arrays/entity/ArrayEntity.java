package lukyanov.task.arrays.entity;

import lukyanov.task.arrays.observer.ArrayEvent;
import lukyanov.task.arrays.observer.ArrayObservable;
import lukyanov.task.arrays.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayEntity extends AbstractArrayEntity implements ArrayObservable {
    private static final Logger logger = LogManager.getLogger(ArrayEntity.class);
    private int[] numbers;
    private List<ArrayObserver> observers = new ArrayList<>();


    public ArrayEntity() {
        super();
    }

    public ArrayEntity(int id, int[] numbers) {
        super(id);
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    public ArrayEntity(int[] numbers) {
        super();
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
    public void attach(ArrayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void detach(ArrayObserver observer) {
        if(observer != null){
            observers.add(observer);
        }
    }

    @Override
    public void notifyObserver() {
        ArrayEvent arrayEvent = new ArrayEvent(this);
        for (ArrayObserver arrayObserver : observers) {
        }
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
