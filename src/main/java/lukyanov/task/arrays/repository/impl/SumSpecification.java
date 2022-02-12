package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.action.ArrayAction;
import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.Specification;

public class SumSpecification implements Specification {

    private int sum;

    public SumSpecification(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        ArrayActionImpl action = new ArrayActionImpl();
        return action.getSummary(arrayEntity) > sum;
    }
}
