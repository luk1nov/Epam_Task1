package lukyanov.task.arrays.service;

public class IdGenerator {
    private static final long MIN_ID = 1;
    private static final long MAX_ID = 100_000;
    private static long idCounter = 0;

    public IdGenerator() {

    }

    public static long idGenerate(){
        idCounter++;
        if(MIN_ID + idCounter >= MAX_ID){
            idCounter = 0;
        }
        return idCounter;
    }
}

