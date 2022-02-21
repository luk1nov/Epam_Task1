package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.comparator.ArrayEntityNumbersComparator;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.service.IdGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRepositoryImplTest {

    private final ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();

    @Test
    public void addArray() {
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1, 5, 6});
        repository.addArray(expectedArray);
        assertEquals(repository.get(0), expectedArray);
    }

    @Test
    public void addAllArrays() {
        List<ArrayEntity> arrayEntityList = new ArrayList<>();
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1, 5, 6});
        arrayEntityList.add(expectedArray);
        repository.addAllArrays(arrayEntityList);
        assertEquals(repository.get(0), expectedArray);
    }

    @Test
    public void removeArray() {
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1, 5, 6});
        repository.addArray(expectedArray);
        assertTrue(repository.removeArray(expectedArray));
    }

    @Test
    public void removeAllArrays() {
        List<ArrayEntity> arrayEntityList = new ArrayList<>();
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1, 5, 6});
        arrayEntityList.add(expectedArray);
        repository.addAllArrays(arrayEntityList);
        assertTrue(repository.removeAllArrays(arrayEntityList));
    }


    @Test
    public void query() {
        IdSpecification idSpecification = new IdSpecification(1);
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1, 5, 6});
        repository.addArray(expectedArray);
        assertEquals(repository.query(idSpecification).get(0), expectedArray);
    }

    @Test
    public void sort() {
        ArrayEntity expectedArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{-1, 6, 7});
        ArrayEntityNumbersComparator numbersComparator = new ArrayEntityNumbersComparator();
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{4, 6, 7}));
        repository.addArray(expectedArray);
        assertEquals(repository.sort(numbersComparator).get(0), expectedArray);
    }
}