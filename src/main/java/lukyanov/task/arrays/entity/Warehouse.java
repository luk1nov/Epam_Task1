package lukyanov.task.arrays.entity;

import lukyanov.task.arrays.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private final Map<Long, ArrayStatistics> mapStatistics;


    private Warehouse() {
        this.mapStatistics = new HashMap<>();
    }

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayStatistics getById(long arrayId) {
        return mapStatistics.get(arrayId);
    }

    public boolean containsKey(Long key) {
        return mapStatistics.containsKey(key);
    }

    public ArrayStatistics putById(Long arrayId, ArrayStatistics statistics) {
        return mapStatistics.put(arrayId, statistics);
    }

    public ArrayStatistics removeById(long arrayId) {
        return mapStatistics.remove(arrayId);
    }

    public ArrayStatistics clearValue(long arrayId) {
        return mapStatistics.replace(arrayId, new ArrayStatistics());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append("mapStatistics=").append(mapStatistics);
        sb.append('}');
        return sb.toString();
    }
}
