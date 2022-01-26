package entity;

import java.util.Arrays;

public class ArrayEntity {
    protected int[] array;

    public ArrayEntity(int[] array) {
        this.array = array;
    }

    public ArrayEntity() {
        this.array = new int[]{1, -2, 3, -10, 7, 5};
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getFirstElement(){
        return array[0];
    }

    public int getSize(){
        return array.length;
    }

    @Override
    public String toString() {
        return "ArrayEntity{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
