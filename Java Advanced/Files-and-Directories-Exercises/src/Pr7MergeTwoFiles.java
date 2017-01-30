import java.io.*;
import java.util.ArrayList;

public class Pr7MergeTwoFiles {

    private final static String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private final static String FIRST_TEXT_FILE_PATH = PROJECT_PATH + "text.txt";
    private final static String SECOND_TEXT_FILE_PATH = PROJECT_PATH + "SomeText.txt";
    private final static String RESULT_FILE_PATH = PROJECT_PATH + "result.txt";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(FIRST_TEXT_FILE_PATH));

        ArrayList<String> arrayString = new ArrayList<>();

        String line;

        while ((line = reader.readLine()) != null) {
            arrayString.add(line);
        }

        BufferedReader reader1 = new BufferedReader(new FileReader(SECOND_TEXT_FILE_PATH));

        while ((line = reader1.readLine()) != null) {
            arrayString.add(line);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE_PATH));

        for (int i = 0; i < arrayString.size(); i++) {
            writer.write(String.format("%s\n", arrayString.get(i)));
        }

        reader.close();
        writer.close();

    }
}
