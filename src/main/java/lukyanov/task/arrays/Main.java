package lukyanov.task.arrays;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.entity.Warehouse;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.observer.impl.ArrayObserverImpl;
import lukyanov.task.arrays.parser.FileParser;
import lukyanov.task.arrays.repository.impl.ArrayRepositoryImpl;
import lukyanov.task.arrays.service.CustomArrayListService;
import lukyanov.task.arrays.service.impl.CustomRepositoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final String PATH = "resources/file/number.txt";
    private static final Logger logger = LogManager.getLogger(FileParser.class);


    public static void main(String[] args) {
        try {
            ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
            CustomArrayListService service = new CustomArrayListService();
            List<ArrayEntity> list = service.getArrayFromFile(PATH);
            CustomRepositoryServiceImpl crs = new CustomRepositoryServiceImpl();
            crs.addListInRepo(list);
            Warehouse warehouse = Warehouse.getInstance();
            ArrayEntity array = repository.get(1);
            array.attach(new ArrayObserverImpl());
            logger.info(array);
            logger.info(warehouse);

            array.setNumbers(1,5, 15);

            logger.info(array);
            logger.info(warehouse);


        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
