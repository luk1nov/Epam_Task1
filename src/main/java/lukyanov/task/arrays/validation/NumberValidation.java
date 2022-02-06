package lukyanov.task.arrays.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidation {

    private static final String isArrayEntityString ="^(-?\\d+(\\s+)?;?(\\s+)?)+$";

    public static boolean validateLine(String str){
        return str.matches(isArrayEntityString);
    }
}
