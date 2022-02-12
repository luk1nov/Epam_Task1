package lukyanov.task.arrays.observer;

public interface ArrayObservable {
    void attach(ArrayObserver observer);
    void detach(ArrayObserver observer);
    void notifyObserver();
}
