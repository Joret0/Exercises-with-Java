import java.io.*;

public class Pr5LineNumbers {

    private final static String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private final static String TEXT_FILE_PATH = PROJECT_PATH + "text.txt";
    private final static String RESULT_FILE_PATH = PROJECT_PATH + "result.txt";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE_PATH));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(RESULT_FILE_PATH)));
        String line;
        int counter = 0;

        while ((line = reader.readLine()) != null) {

            counter++;
            writer.write(String.format("%d. %s%n", counter, line));
        }

        reader.close();
        writer.close();
    }
}
