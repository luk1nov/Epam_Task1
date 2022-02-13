package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.ArrayRepository;
import lukyanov.task.arrays.repository.Specification;

import java.util.*;
import java.util.stream.Collectors;

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


    public int getSize(){
        return arrays.size();
    }

    @Override
    public void addArray(ArrayEntity arrayEntity) {
        arrays.add(arrayEntity);
    }

    @Override
    public void addAllArrays(Collection<? extends ArrayEntity> arrayEntities) {
        arrays.addAll(arrayEntities);
    }

    @Override
    public void removeArray(ArrayEntity arrayEntity) {
        arrays.remove(arrayEntity);
    }

    @Override
    public void removeAllArrays(Collection<?> arrayEntities) {
        arrays.removeAll(arrayEntities);
    }

    @Override
    public ArrayEntity get(int index) {
        return arrays.get(index);
    }

    @Override
    public ArrayEntity set(int index, ArrayEntity arrayEntity) {
        return arrays.set(index, arrayEntity);
    }


    @Override
    public List<? super ArrayEntity> query(Specification specification) {
        List<ArrayEntity> list = arrays.stream().
                filter(specification::specify).
                collect(Collectors.toList());
        return list;
    }

    @Override
    public List<ArrayEntity> sort(Comparator<? super ArrayEntity> comparator) {
        List<ArrayEntity> list = arrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return list;
    }


}
