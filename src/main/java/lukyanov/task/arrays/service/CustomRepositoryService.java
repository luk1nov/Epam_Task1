package lukyanov.task.arrays.service;

import lukyanov.task.arrays.entity.ArrayEntity;

import java.util.List;

public interface CustomRepositoryService {

    void addArrayInRepo(ArrayEntity array);

    void addNumberInRepo(int... args);

    void addNumberInRepo(long id, int[] args);

    void addListInRepo(List<ArrayEntity> arrayEntities);
}
