package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdSpecificationTest {
    private final IdSpecification specification = new IdSpecification(1);

    @Test
    void specify() {
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        ArrayEntity array = new ArrayEntity(1, new int[]{1,2,3});
        repository.addArray(array);
        assertEquals(array, repository.query(specification).get(0));
    }
}