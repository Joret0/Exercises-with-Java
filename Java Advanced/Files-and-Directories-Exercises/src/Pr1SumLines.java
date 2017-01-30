import java.io.*;

public class Pr1SumLines {

    private final static String path = "/src/resources/SomeText.txt";

    public static void main(String[] args) throws FileNotFoundException {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;

        File someFile = new File(filePath);

        FileReader fileReader = new FileReader(someFile);

        try(BufferedReader reader = new BufferedReader(fileReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
