package lukyanov.task.arrays.entity;

import java.util.EventObject;

public class ArrayEntityEvent extends EventObject {

    public ArrayEntityEvent(ArrayEntity source) {
        super(source);
    }

    @Override
    public ArrayEntity getSource() {
        return (ArrayEntity) super.getSource();
    }
}
