package lukyanov.task.arrays.validation;

import lukyanov.task.arrays.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidation {

    private static final String REGEX_IS_ARRAY ="^(-?\\d+(\\s+)?;?(\\s+)?)*$";
    private static final Logger logger = LogManager.getLogger();

    public static boolean validateLine(String str){
        Pattern pattern = Pattern.compile(REGEX_IS_ARRAY);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
