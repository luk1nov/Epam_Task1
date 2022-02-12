package lukyanov.task.arrays.repository;

import lukyanov.task.arrays.entity.ArrayEntity;

public interface Specification {

    boolean specify(ArrayEntity arrayEntity);
}
