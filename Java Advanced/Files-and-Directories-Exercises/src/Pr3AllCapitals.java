import java.io.*;

public class Pr3AllCapitals {

    private final static String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private final static String RESULT_PATH =  PROJECT_PATH + "results.txt";
    private final static String path = "/src/resources/capitalText.txt";

    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        File someFile = new File(filePath);
        FileReader fileReader = new FileReader(someFile);
        BufferedReader reader = new BufferedReader(fileReader);

        String text = "";
        String line;

        while ((line = reader.readLine()) != null) {
            text += line.toUpperCase() + "\r\n";
        }

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(RESULT_PATH)));

        printWriter.write(text);
        printWriter.flush();
        printWriter.close();
        reader.close();
    }
}
