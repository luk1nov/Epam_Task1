package lukyanov.task.arrays.observer.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.entity.ArrayStatistics;
import lukyanov.task.arrays.entity.Warehouse;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.observer.ArrayEvent;
import lukyanov.task.arrays.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger();


    public void replaceStatistic(ArrayEvent event){
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.clearValue(sourceId);
        } catch (CustomException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void updateMinValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayStatistics statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = ArrayActionImpl.getInstance();
            OptionalInt min = action.getMinValue(source);
            if (min.isPresent()){
                statistics.setMin(min.getAsInt());
            }
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateMaxValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayStatistics statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = new ArrayActionImpl();
            OptionalInt max = action.getMaxValue(source);
            if (max.isPresent()){
                statistics.setMax(max.getAsInt());
            }
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateAvgValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayStatistics statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = new ArrayActionImpl();
            OptionalDouble avg = action.getAvgValue(source);
            if (avg.isPresent()){
                statistics.setAvg(avg.getAsDouble());
            }
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateSumValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayStatistics statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = new ArrayActionImpl();
            statistics.setSum(action.getSummary(source));
        } catch (CustomException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}