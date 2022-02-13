package lukyanov.task.arrays.service.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.impl.ArrayRepositoryImpl;
import lukyanov.task.arrays.service.CustomRepositoryService;

import java.util.List;

public class CustomRepositoryServiceImpl implements CustomRepositoryService {

    @Override
    public void addArrayInRepo(ArrayEntity array){
        ArrayRepositoryImpl arrayRepository = ArrayRepositoryImpl.getInstance();
        arrayRepository.addArray(array);
        CustomWarehouseServiceImpl filler = new CustomWarehouseServiceImpl();
        filler.putArrayInWarehouse(array);
    }

    @Override
    public void addNumberInRepo(int... args){
        ArrayEntity array = new ArrayEntity(args);
        addArrayInRepo(array);
    }

    @Override
    public void addListInRepo(List<ArrayEntity> arrayEntities){
        for (ArrayEntity array: arrayEntities) {
            addArrayInRepo(array);
        }
    }

}
