package lukyanov.task.arrays.entity;

import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger(CustomFileReader.class);
    private static Warehouse instance;
    private Map<Long, ArrayStatistics> mapStatistics;

    public Warehouse() {
        this.mapStatistics = new HashMap<>();
    }

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public int getWarehouseSize(){
        return mapStatistics.size();
    }

    public ArrayStatistics getById(long arrayId) throws CustomException {
        if (mapStatistics.containsKey(arrayId)) {
            ArrayStatistics statistics = mapStatistics.get(arrayId);
            return statistics;
        } else {
            logger.error("element with id(" + arrayId + ") not found");
            throw new CustomException("element with id(" + arrayId + ") not found");
        }
    }

    public ArrayStatistics putById(Long arrayId, ArrayStatistics statistics) {
        return mapStatistics.put(arrayId, statistics);
    }

    public ArrayStatistics removeById(long arrayId) throws CustomException{
        if (mapStatistics.containsKey(arrayId)) {
            return mapStatistics.remove(arrayId);
        } else {
            logger.error("element with id(" + arrayId + ") not found");
            throw new CustomException("element with id(" + arrayId + ") not found");
        }
    }


}
