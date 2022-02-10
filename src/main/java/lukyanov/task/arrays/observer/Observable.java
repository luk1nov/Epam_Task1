package lukyanov.task.arrays.observer;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();
}
