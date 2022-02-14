package lukyanov.task.arrays.service.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.entity.ArrayStatistics;
import lukyanov.task.arrays.entity.Warehouse;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.service.IdGenerator;
import lukyanov.task.arrays.service.impl.CustomWarehouseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomWarehouseServiceImplTest {
    private final Warehouse warehouse = Warehouse.getInstance();
    private final ArrayStatistics statistics = new ArrayStatistics(10, 5, 7, 21);
    private final CustomWarehouseServiceImpl cws = new CustomWarehouseServiceImpl();
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void beforeEachWarehousePut(){
        logger.info(statistics);
    }

    @Test
    @DisplayName("putArrayInWarehouse")
    void putArrayInWarehouse() {
        try {
            cws.putArrayInWarehouse(new ArrayEntity(4, new int[]{10, 5, 6}));
            assertEquals(warehouse.getById(4), statistics);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @DisplayName("putNumbersInWarehouse")
    void putNumbersInWarehouse() {
        try {
            cws.putNumbersInWarehouse(10, 5, 6);
            assertEquals(warehouse.getById(1), statistics);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @DisplayName("putListInWarehouse")
    void putListInWarehouse() {
        ArrayStatistics statistics2 = new ArrayStatistics(18, 1, 7, 21);
        List<ArrayEntity> list = new ArrayList<>();
        list.add(new ArrayEntity(IdGenerator.idGenerate(), new int[]{10, 5, 6}));
        list.add(new ArrayEntity(IdGenerator.idGenerate(), new int[]{18, 1, 2}));
        cws.putListInWarehouse(list);
        logger.info(warehouse);
        try {
            assertEquals(statistics, warehouse.getById(1));
            assertEquals(statistics2, warehouse.getById(2));
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}