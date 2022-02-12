package lukyanov.task.arrays.observer;

public interface ArrayObserver {
    void updateMinValue(ArrayEvent event);

    void updateMaxValue(ArrayEvent event);

    void updateAvgValue(ArrayEvent event);

    void updateSumValue(ArrayEvent event);

}
