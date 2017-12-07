package c_barracksWars.io;

public final class ConsoleOutputWriter {
    public static void writeLine(String line) {
        if (!line.isEmpty() && !line.equals("fight")) {
            System.out.println(line);
        }
    }
}
