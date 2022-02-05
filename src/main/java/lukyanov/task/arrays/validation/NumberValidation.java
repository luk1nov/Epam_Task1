package lukyanov.task.arrays.validation;

public class NumberValidation {
    public static boolean checkWholeString(String str){
        return str.matches("^(\\d+( +)?;?( +)?)+$");
    }
}
