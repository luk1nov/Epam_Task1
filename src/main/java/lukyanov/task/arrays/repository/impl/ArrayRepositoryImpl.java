package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.ArrayRepository;
import lukyanov.task.arrays.repository.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayRepositoryImpl implements ArrayRepository {
    List<ArrayEntity> arrays;

    public ArrayRepositoryImpl() {
        arrays = new ArrayList<>();
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
                filter(i -> specification.specify(i)).
                collect(Collectors.toList());
        return list;
    }

    @Override
    public List sort(Comparator<? super ArrayEntity> comparator) {
        List<ArrayEntity> list = arrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return list;
    }
}
