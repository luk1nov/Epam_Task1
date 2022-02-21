package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.service.IdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositiveLessThanSpecificationTest {

    private final PositiveLessThanSpecification specification = new PositiveLessThanSpecification(4);
    private final ArrayActionImpl action = ArrayActionImpl.getInstance();

    @Test
    public void specify() {
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1,-2,3});
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{4, 5, 6, 8, 7}));
        repository.addArray(expectedArray);
        long expectedPositive = action.findPositiveElements(expectedArray);
        assertEquals(action.findPositiveElements(repository.query(specification).get(0)), expectedPositive);
    }
}