package lukyanov.task.arrays.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdGeneratorTest {

    @Test
    void idGenerate() {
        long realId = IdGenerator.idGenerate();
        long expectedId = 1;
        assertEquals(expectedId, realId);

        realId = IdGenerator.idGenerate();
        assertEquals(++expectedId, realId);
    }
}