package lukyanov.task.arrays.observer;

import lukyanov.task.arrays.entity.AbstractArrayEntity;
import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.EventObject;

public class ArrayEvent extends EventObject {

    public ArrayEvent(AbstractArrayEntity source) {
        super(source);
    }

    @Override
    public ArrayEntity getSource() {
        return (ArrayEntity) super.getSource();
    }
}
