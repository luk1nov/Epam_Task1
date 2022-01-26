import entity.ArrayEntity;
import service.Summary;

public class Runner {
    public static void main(String[] args) {
        ArrayEntity arrayEntity = new ArrayEntity();
        Summary summary = new Summary();
        System.out.println(summary.findMaxValue(arrayEntity));
        System.out.println(summary.findMinValue(arrayEntity));
    }
}
