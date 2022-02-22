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

import java.util.Optional;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger();


    public void clearStatistic(ArrayEvent event){
        ArrayEntity source = event.getSource();
        long sourceId = source.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.clearValue(sourceId);
    }


    @Override
    public void updateMinValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayStatistics statistics = null;
            statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = ArrayActionImpl.getInstance();
            Optional<Integer> min = action.findMinValue(source);
            if (min.isPresent()){
                statistics.setMin(min.get());
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
            ArrayActionImpl action = ArrayActionImpl.getInstance();
            Optional<Integer> max = action.findMaxValue(source);
            if (max.isPresent()){
                statistics.setMax(max.get());
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
            ArrayActionImpl action = ArrayActionImpl.getInstance();
            Optional<Double> avg = action.findAvgValue(source);
            if (avg.isPresent()){
                statistics.setAvg(avg.get());
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
            ArrayActionImpl action = ArrayActionImpl.getInstance();
            statistics.setSum(action.findSum(source));
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}