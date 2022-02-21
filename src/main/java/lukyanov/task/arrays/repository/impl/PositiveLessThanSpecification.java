package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.Specification;

public class PositiveLessThanSpecification implements Specification {

    private int numberOfPositiveElements;

    public PositiveLessThanSpecification(int numberOfPositiveElements) {
        this.numberOfPositiveElements = numberOfPositiveElements;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        ArrayActionImpl action = ArrayActionImpl.getInstance();
        return action.findPositiveElements(arrayEntity) < numberOfPositiveElements;
    }


}
