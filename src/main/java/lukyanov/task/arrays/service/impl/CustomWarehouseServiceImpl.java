package lukyanov.task.arrays.service.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.entity.ArrayStatistics;
import lukyanov.task.arrays.entity.Warehouse;
import lukyanov.task.arrays.service.CustomWarehouseService;
import lukyanov.task.arrays.service.IdGenerator;

import java.util.List;
import java.util.Optional;

public class CustomWarehouseServiceImpl implements CustomWarehouseService {

    @Override
    public void putArrayInWarehouse(ArrayEntity array){
        Warehouse warehouse = Warehouse.getInstance();
        ArrayActionImpl action = ArrayActionImpl.getInstance();
        long id = array.getId();
        int sum = action.findSum(array);
        Optional<Integer> min = action.findMinValue(array);
        Optional<Integer> max = action.findMaxValue(array);
        Optional<Double> avg = action.findAvgValue(array);
        ArrayStatistics statistics = new ArrayStatistics();
        statistics.setSum(sum);
        if(min.isPresent()){
            statistics.setMin(min.get());
        }
        if(max.isPresent()){
            statistics.setMax(max.get());
        }
        if(avg.isPresent()){
            statistics.setAvg(avg.get());
        }
        warehouse.putById(id, statistics);
    }

    @Override
    public void putNumbersInWarehouse(int... args){
        ArrayEntity array = new ArrayEntity(IdGenerator.idGenerate(), args);
        putArrayInWarehouse(array);
    }

    @Override
    public void putNumbersInWarehouse(long id, int[] args) {
        ArrayEntity array = new ArrayEntity(id, args);
        putArrayInWarehouse(array);
    }


    @Override
    public void putListInWarehouse(List<ArrayEntity> arrayEntities){
        for (ArrayEntity array: arrayEntities) {
            putArrayInWarehouse(array);
        }
    }

}
