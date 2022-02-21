package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.ArrayRepository;
import lukyanov.task.arrays.repository.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static ArrayRepositoryImpl instance;
    private List<ArrayEntity> arrays;

    public ArrayRepositoryImpl() {
        arrays = new ArrayList<>();
    }

    public static ArrayRepositoryImpl getInstance(){
        if(instance == null){
            instance = new ArrayRepositoryImpl();
        }
        return instance;
    }


    @Override
    public boolean addArray(ArrayEntity arrayEntity) {
        return arrays.add(arrayEntity);
    }

    @Override
    public boolean addAllArrays(List<ArrayEntity> arrayEntities) {
        return arrays.addAll(arrayEntities);
    }

    @Override
    public boolean removeArray(ArrayEntity arrayEntity) {
        return arrays.remove(arrayEntity);
    }


    @Override
    public boolean removeAllArrays(List<ArrayEntity> arrayEntities) {
        return arrays.removeAll(arrayEntities);
    }

    @Override
    public ArrayEntity get(int index) {
        return arrays.get(index);
    }

    @Override
    public ArrayEntity set(int index, ArrayEntity arrayEntity) {
        return arrays.set(index, arrayEntity);
    }

    public int size() {
        return arrays.size();
    }

    @Override
    public List<ArrayEntity> query(Specification specification) {
        return arrays.stream()
                .filter(specification::specify)
                .toList();
    }

    @Override
    public List<ArrayEntity> sort(Comparator<? super ArrayEntity> comparator) {
        return arrays.stream()
                .sorted(comparator)
                .toList();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayRepositoryImpl{");
        sb.append("arrays=").append(arrays);
        sb.append('}');
        return sb.toString();
    }
}
