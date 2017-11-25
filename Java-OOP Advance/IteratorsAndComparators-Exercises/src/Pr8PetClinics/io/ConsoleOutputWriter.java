package Pr8PetClinics.io;

public class ConsoleOutputWriter {
    public void writeLine(String output) {
        if (!output.isEmpty())
            System.out.println(output);
    }

    public void writeLine(boolean output) {
        System.out.println(output);
    }
}
