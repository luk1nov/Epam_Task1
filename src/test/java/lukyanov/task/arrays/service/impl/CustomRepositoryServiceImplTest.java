package lukyanov.task.arrays.service.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.entity.Warehouse;
import lukyanov.task.arrays.observer.impl.ArrayObserverImpl;
import lukyanov.task.arrays.repository.impl.ArrayRepositoryImpl;
import lukyanov.task.arrays.service.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomRepositoryServiceImplTest {
    private final ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
    private final ArrayEntity expectedArray = new ArrayEntity(1, new int[]{10, 6, 5});
    private final CustomRepositoryServiceImpl crs = new CustomRepositoryServiceImpl();
    private static final Logger logger = LogManager.getLogger();

    @Test
    void addArrayInRepo() {
        crs.addArrayInRepo(new ArrayEntity(IdGenerator.idGenerate(), new int[]{10, 6, 5}));
        assertEquals(expectedArray, repository.get(0));
    }

    @Test
    void addNumberInRepo() {
        Warehouse warehouse = Warehouse.getInstance();
        crs.addNumberInRepo(10, 6, 5);
        assertEquals(expectedArray, repository.get(0));
    }

    @Test
    void addListInRepo() {
        ArrayEntity expectedArray2 = new ArrayEntity(IdGenerator.idGenerate(), new int[]{18, 1, 2});
        List<ArrayEntity> list = new ArrayList<>();
        list.add(new ArrayEntity(IdGenerator.idGenerate(), new int[]{10, 6, 5}));
        list.add(new ArrayEntity(IdGenerator.idGenerate(), new int[]{18, 1, 2}));
        crs.addListInRepo(list);
        assertEquals(expectedArray, repository.get(0));
        assertEquals(expectedArray2, repository.get(1));
    }
}