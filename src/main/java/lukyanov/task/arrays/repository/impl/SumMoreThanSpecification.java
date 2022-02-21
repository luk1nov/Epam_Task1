package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.Specification;

public class SumMoreThanSpecification implements Specification {

    private int sum;

    public SumMoreThanSpecification(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        ArrayActionImpl action = ArrayActionImpl.getInstance();
        return action.findSum(arrayEntity) > sum;
    }
}
