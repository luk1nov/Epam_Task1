package lukyanov.task.arrays.repository.impl;

import lukyanov.task.arrays.action.impl.ArrayActionImpl;
import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.repository.Specification;

import java.util.Optional;

public class MinSpecification implements Specification {

    private int min;

    public MinSpecification(int min) {
        this.min = min;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        ArrayActionImpl action = ArrayActionImpl.getInstance();
        Optional<Integer> arrayEntityMin = action.findMinValue(arrayEntity);
        if(arrayEntityMin.isPresent()){
            return arrayEntityMin.get() == min;
        } else {
            return false;
        }
    }
}
