package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.service.IdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthSpecificationTest {
    private final LengthSpecification specification = new LengthSpecification(3);

    @Test
    public void specify() {
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1,2,3});
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{4,5,6,7}));
        repository.addArray(expectedArray);
        assertEquals(repository.query(specification).get(0), expectedArray);

    }
}