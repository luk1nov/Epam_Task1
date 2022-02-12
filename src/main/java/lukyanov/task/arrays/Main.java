package lukyanov.task.arrays;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.observer.ArrayEvent;
import lukyanov.task.arrays.observer.ArrayObserver;
import lukyanov.task.arrays.observer.impl.ArrayObserverImpl;
import lukyanov.task.arrays.parser.FileParser;
import lukyanov.task.arrays.repository.ArrayRepository;
import lukyanov.task.arrays.repository.impl.ArrayRepositoryImpl;
import lukyanov.task.arrays.service.ArrayEntityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final String PATH = "resources/file/numbers.txt";
    private static final Logger logger = LogManager.getLogger(FileParser.class);


    public static void main(String[] args) {
        ArrayEntityService aes = new ArrayEntityService();
        try {
            ArrayRepository repository = new ArrayRepositoryImpl();
            repository.addAllArrays(aes.getArrayFromFile(PATH));
            ArrayObserverImpl observer = new ArrayObserverImpl();
            repository.get(0).attach(observer);
            repository.get(0).setNumbers(1,2,3,4);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
