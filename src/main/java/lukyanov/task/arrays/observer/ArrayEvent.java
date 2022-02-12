package lukyanov.task.arrays.observer;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.EventObject;

public class ArrayEvent extends EventObject {

    public ArrayEvent(ArrayEntity source) {
        super(source);
    }

    @Override
    public ArrayEntity getSource() {
        return (ArrayEntity) super.getSource();
    }
}
