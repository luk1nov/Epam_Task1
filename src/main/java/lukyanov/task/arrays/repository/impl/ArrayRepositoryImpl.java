package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.ArrayRepository;
import lukyanov.task.arrays.repository.Specification;

import java.util.ArrayList;
import java.util.Collection;
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
        return arrays.stream().
                filter(specification::specify).
                toList();
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
