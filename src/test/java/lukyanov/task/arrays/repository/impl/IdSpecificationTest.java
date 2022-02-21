package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdSpecificationTest {
    private final IdSpecification specification = new IdSpecification(1);


    @Test
    public void specify() {
        long expectedId = 1;
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        ArrayEntity array = new ArrayEntity(expectedId, new int[]{1,2,3});
        repository.addArray(array);
        assertEquals(repository.query(specification).get(0).getId(), expectedId);
    }
}