import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Pr12CreateZipArchive {

    private final static String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";

    public static void main(String[] args) throws IOException {

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(PROJECT_PATH + "text-files.zip"));
        FileInputStream fileInputStream = new FileInputStream(new File(PROJECT_PATH + "words.txt"));

        int byteCounter;

        zipOutputStream.putNextEntry(new ZipEntry("words.txt"));
        while ((byteCounter = fileInputStream.read()) != -1) {
            zipOutputStream.write(byteCounter);
        }
        zipOutputStream.closeEntry();

        zipOutputStream.putNextEntry(new ZipEntry("text.txt"));
        fileInputStream = new FileInputStream(new File(PROJECT_PATH + "text.txt"));
        while ((byteCounter = fileInputStream.read()) != -1) {
            zipOutputStream.write(byteCounter);
        }
        zipOutputStream.closeEntry();

        zipOutputStream.putNextEntry(new ZipEntry("capitalText.txt"));
        fileInputStream = new FileInputStream(new File(PROJECT_PATH + "capitalText.txt"));
        while ((byteCounter = fileInputStream.read()) != -1) {
            zipOutputStream.write(byteCounter);
        }
        zipOutputStream.closeEntry();

        zipOutputStream.finish();
        zipOutputStream.close();
    }
}
