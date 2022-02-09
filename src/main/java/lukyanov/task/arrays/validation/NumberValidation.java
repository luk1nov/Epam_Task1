package lukyanov.task.arrays.validation;

import lukyanov.task.arrays.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidation {

    private static final String REGEX_EXPRESSION ="^(-?\\d+(\\s+)?;?(\\s+)?)*$";
    private static final Logger logger = LogManager.getLogger(CustomFileReader.class);

    public static boolean validateLine(String str){
        return str.matches(REGEX_EXPRESSION);
    }
}
