package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.service.IdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthSpecificationTest {
    private final LengthSpecification specification = new LengthSpecification(3);

    @Test
    void specify() {
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        ArrayEntity firstArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1,2,3});
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{1,2,3}));
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{4,5,6,7}));
        assertEquals(firstArray, repository.query(specification).get(0));
    }
}