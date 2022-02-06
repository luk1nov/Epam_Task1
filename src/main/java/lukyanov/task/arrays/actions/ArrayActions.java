package lukyanov.task.arrays.actions;

import lukyanov.task.arrays.entity.ArrayEntity;

public interface ArrayActions {

    int getMinValue(ArrayEntity arrayEntity);

    int getMaxValue(ArrayEntity arrayEntity);

    double getAvgValue(ArrayEntity arrayEntity);

    int getSummary(ArrayEntity arrayEntity);

    long getNumberOfPlusElements(ArrayEntity arrayEntity);

    long getNumberOfMinusElements(ArrayEntity arrayEntity);

    ArrayEntity replaceElement(ArrayEntity arrayEntity, int desiredElement, int newElement);
}
