package lukyanov.task.arrays.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdGeneratorTest {

    @Test
    public void idGenerate() {
        long realId = IdGenerator.idGenerate();
        long expectedId = 1;
        assertEquals(realId, expectedId);
    }
}