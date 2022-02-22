package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.service.IdGenerator;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MinSpecificationTest {
    private final MinSpecification specification = new MinSpecification(3);
    private final ArrayActionImpl action = ArrayActionImpl.getInstance();

    @Test
    public void specify() {
        int expectedMin = 3;
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{1,2,3}));
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{8,5,3}));
        Optional<Integer> min = action.findMinValue(repository.query(specification).get(0));
        assertEquals(min.get(), expectedMin);
    }
}