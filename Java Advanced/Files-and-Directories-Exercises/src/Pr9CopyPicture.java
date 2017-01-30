import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pr9CopyPicture {

    private final static String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\Desktop\\papka\\formula.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(PROJECT_PATH + "formula.jpg");
        int byteCounter;

        while ((byteCounter = fileInputStream.read()) != -1) {

            fileOutputStream.write(byteCounter);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
