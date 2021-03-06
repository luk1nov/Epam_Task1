package lukyanov.task.arrays.observer.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.entity.ArrayStatistics;
import lukyanov.task.arrays.entity.Warehouse;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.observer.ArrayEvent;
import lukyanov.task.arrays.service.impl.CustomWarehouseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArrayObserverImplTest {
    private static final Warehouse warehouse = Warehouse.getInstance();
    private static final Logger logger = LogManager.getLogger();
    private static final ArrayActionImpl action = ArrayActionImpl.getInstance();
    private final static long realId = 1;
    private final ArrayEntity array = new ArrayEntity(1, new int[]{10, 5, 6});
    private final ArrayObserverImpl observer = new ArrayObserverImpl();
    private final ArrayEvent event = new ArrayEvent(array);


    @BeforeEach
    public void setUp()  {
        CustomWarehouseServiceImpl cws = new CustomWarehouseServiceImpl();
        cws.putArrayInWarehouse(array);
    }

    @Test
    public void clearStatistic() {
        try {
            ArrayStatistics expectedStatistics = new ArrayStatistics();
            observer.clearStatistic(event);
            assertEquals(warehouse.getById(realId), expectedStatistics);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void updateMinValue() {
        try {
            array.setNumbers(4,5,6);
            observer.updateMinValue(event);
            assertEquals(action.findMinValue(array), warehouse.getById(realId).getMin());
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void updateMaxValue() {
        try {
            array.setNumbers(1,57,4);
            observer.updateMaxValue(event);
            assertEquals(action.findMaxValue(array), warehouse.getById(realId).getMax());
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void updateAvgValue(){
        try {
            array.setNumbers(1,2,3);
            observer.updateAvgValue(event);
            assertEquals(action.findAvgValue(array), warehouse.getById(realId).getAvg());
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void updateSumValue() {
        try {
            array.setNumbers(1,2,3);
            observer.updateSumValue(event);
            assertEquals(action.findSum(array), warehouse.getById(realId).getSum());
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        try {
            logger.info(warehouse.getById(realId));
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}