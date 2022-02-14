package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.Specification;

public class LengthSpecification implements Specification {

    int length;

    public LengthSpecification(int length) {
        this.length = length;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        return arrayEntity.getLength() == length;
    }
}
