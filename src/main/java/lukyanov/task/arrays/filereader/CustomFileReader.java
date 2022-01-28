package lukyanov.task.arrays.filereader;

import lukyanov.task.arrays.customexception.CustomException;

import java.io.*;

public class CustomFileReader {

    public void readFile() throws CustomException {
        File file = new File("resources/numbers.txt");

        try (FileReader fr = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new CustomException(e.getMessage());
        }
    }



}
