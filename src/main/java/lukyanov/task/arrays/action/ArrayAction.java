package lukyanov.task.arrays.action;

import lukyanov.task.arrays.entity.ArrayEntity;

public interface ArrayAction {

    int getMinValue(ArrayEntity arrayEntity);

    int getMaxValue(ArrayEntity arrayEntity);

    double getAvgValue(ArrayEntity arrayEntity);

    int getSummary(ArrayEntity arrayEntity);

    long getNumberOfPlusElements(ArrayEntity arrayEntity);

    long getNumberOfMinusElements(ArrayEntity arrayEntity);

    ArrayEntity replaceElement(ArrayEntity arrayEntity, int desiredElement, int newElement);
}
