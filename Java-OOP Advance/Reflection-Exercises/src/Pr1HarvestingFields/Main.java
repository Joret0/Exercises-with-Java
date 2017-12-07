package Pr1HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String TERMINATE_COMMAND = "HARVEST";
    public static void main(String[] args) throws IOException {
        ICommandExecutor executor = new CommandExecutor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        while (!command.equals(TERMINATE_COMMAND)) {
            executor.execute(command);
            command = reader.readLine();
        }
    }
}
