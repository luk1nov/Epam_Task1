package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.Specification;

public class IdSpecification implements Specification {

    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        return arrayEntity.getId() == id;
    }
}
