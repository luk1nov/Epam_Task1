package lukyanov.task.arrays.service.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.entity.ArrayStatistics;
import lukyanov.task.arrays.entity.Warehouse;
import lukyanov.task.arrays.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomWarehouseServiceImplTest {
    private final Warehouse warehouse = Warehouse.getInstance();
    private final ArrayStatistics expectedStatistics = new ArrayStatistics(10, 5, 7, 21);
    private final CustomWarehouseServiceImpl cws = new CustomWarehouseServiceImpl();
    private static final Logger logger = LogManager.getLogger();


    @Test
    public void putArrayInWarehouse() {
        try {
            cws.putArrayInWarehouse(new ArrayEntity(1, new int[]{10, 5, 6}));
            assertEquals(warehouse.getById(1), expectedStatistics);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void putNumbersInWarehouse() {
        try {
            cws.putNumbersInWarehouse(10, 5, 6);
            assertEquals(warehouse.getById(1), expectedStatistics);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void putNumbersAndIdInWarehouse() {
        try {
            final long id = 3;
            cws.putNumbersInWarehouse(id, new int[]{10, 5, 6});
            assertEquals(warehouse.getById(id), expectedStatistics);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void putListInWarehouse() {
        try {
            List<ArrayEntity> list = new ArrayList<>();
            final long id = 4;
            list.add(new ArrayEntity(id, new int[]{10, 5, 6}));
            cws.putListInWarehouse(list);
            logger.info(warehouse);
            assertEquals(expectedStatistics, warehouse.getById(id));
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}