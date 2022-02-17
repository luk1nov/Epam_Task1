package lukyanov.task.arrays.entity;

import lukyanov.task.arrays.observer.ArrayEvent;
import lukyanov.task.arrays.observer.ArrayObservable;
import lukyanov.task.arrays.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class AbstractArrayEntity implements ArrayObservable {
    private static final Logger logger = LogManager.getLogger();
    private ArrayObserver arrayObserver;
    private long id;

    public AbstractArrayEntity() {
    }

    public AbstractArrayEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayObserver getArrayObserver() {
        return arrayObserver;
    }

    public void setArrayObserver(ArrayObserver arrayObserver) {
        this.arrayObserver = arrayObserver;
    }

    @Override
    public void attach(ArrayObserver observer) {
        if(arrayObserver == null){
            arrayObserver = observer;
        } else {
            logger.error("observer already used");
        }
    }

    @Override
    public void detach(ArrayObserver observer) {
        if(arrayObserver != null){
            arrayObserver = null;
        } else {
            logger.error("observer not used");
        }
    }

    @Override
    public void notifyObserver() {
        ArrayEvent event = new ArrayEvent(this);
        if (arrayObserver != null) {
            arrayObserver.clearStatistic(event);
            arrayObserver.updateAvgValue(event);
            arrayObserver.updateSumValue(event);
            arrayObserver.updateMaxValue(event);
            arrayObserver.updateMinValue(event);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractArrayEntity that = (AbstractArrayEntity) o;
        return id == that.id && Objects.equals(arrayObserver, that.arrayObserver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayObserver, id);
    }
}
