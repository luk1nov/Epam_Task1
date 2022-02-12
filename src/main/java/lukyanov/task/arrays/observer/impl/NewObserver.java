package lukyanov.task.arrays.observer.impl;

import lukyanov.task.arrays.observer.ArrayEvent;
import lukyanov.task.arrays.observer.ArrayObserver;

public class NewObserver implements ArrayObserver {
    @Override
    public void updateMinValue(ArrayEvent event) {
        System.out.println("min val not updated");
    }

    @Override
    public void updateMaxValue(ArrayEvent event) {
        System.out.println("max val not updated");
    }

    @Override
    public void updateAvgValue(ArrayEvent event) {
        System.out.println("avg val not updated");
    }

    @Override
    public void updateSumValue(ArrayEvent event) {
        System.out.println("sum val not updated");
    }
}
