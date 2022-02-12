package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.Specification;

public class PositiveSpecification implements Specification {

    int numberOfPositiveElements;

    public PositiveSpecification(int numberOfPositiveElements) {
        this.numberOfPositiveElements = numberOfPositiveElements;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        ArrayActionImpl action = new ArrayActionImpl();
        return action.getNumberOfPlusElements(arrayEntity) < numberOfPositiveElements;
    }
}
