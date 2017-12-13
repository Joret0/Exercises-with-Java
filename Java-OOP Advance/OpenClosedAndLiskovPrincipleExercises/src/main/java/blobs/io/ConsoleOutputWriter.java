package blobs.io;

public class ConsoleOutputWriter {
    public void writeLine(String output) {
        if (!output.isEmpty()) {
            System.out.println(output);
        }
    }
}
