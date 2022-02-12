package lukyanov.task.arrays.observer;

import lukyanov.task.arrays.observer.impl.ArrayObserverImpl;

public interface ArrayObservable<T extends ArrayObserver> {
    void attach(T observer);
    void detach(T observer);

    void attach(ArrayObserverImpl observer);

    void detach(ArrayObserverImpl observer);

    void notifyObserver();
}
