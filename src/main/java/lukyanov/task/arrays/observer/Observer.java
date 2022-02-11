package lukyanov.task.arrays.observer;

import lukyanov.task.arrays.entity.ArrayEntityEvent;

public interface Observer {
    void updateMinValue(ArrayEntityEvent event);

    void updateMaxValue(ArrayEntityEvent event);

    void updateAvgValue(ArrayEntityEvent event);

}
