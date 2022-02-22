package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.service.IdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumMoreThanSpecificationTest {
    private final SumMoreThanSpecification specification = new SumMoreThanSpecification(10);
    private final ArrayActionImpl action = ArrayActionImpl.getInstance();

    @Test
    public void specify() {
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1, 8, 5});
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{1, -5, 6, -8}));
        repository.addArray(expectedArray);
        int expectedSum = action.findSum(expectedArray);
        assertEquals(action.findSum(repository.query(specification).get(0)), expectedSum);
    }
}