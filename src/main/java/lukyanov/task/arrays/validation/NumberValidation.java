package lukyanov.task.arrays.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidation {

    private static final Logger logger = LogManager.getLogger();

    public static boolean checkWholeString(String str){
        return str.matches("^(\\d+( +)?;?( +)?)+$");
    }
}
