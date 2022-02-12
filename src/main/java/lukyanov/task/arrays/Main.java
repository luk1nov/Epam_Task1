package lukyanov.task.arrays;

import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.observer.impl.ArrayObserverImpl;
import lukyanov.task.arrays.parser.FileParser;
import lukyanov.task.arrays.repository.ArrayRepository;
import lukyanov.task.arrays.repository.impl.ArrayRepositoryImpl;
import lukyanov.task.arrays.service.ArrayEntityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final String PATH = "resources/file/numbers.txt";
    private static final Logger logger = LogManager.getLogger(FileParser.class);


    public static void main(String[] args) {
        ArrayEntityService aes = new ArrayEntityService();
        try {
            ArrayRepository repository = new ArrayRepositoryImpl();
            repository.addAllArrays(aes.getArrayFromFile(PATH));
            repository.get(0).attach(new ArrayObserverImpl());
            repository.get(0).setNumbers(1,2,3,4);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
