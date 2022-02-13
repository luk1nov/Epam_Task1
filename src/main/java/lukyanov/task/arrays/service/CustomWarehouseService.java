package lukyanov.task.arrays.service;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.List;

public interface CustomWarehouseService {

    void putArrayInWarehouse(ArrayEntity array);

    void putNumbersInWarehouse(int... args);

    void putListInWarehouse(List<ArrayEntity> arrayEntities);

}
