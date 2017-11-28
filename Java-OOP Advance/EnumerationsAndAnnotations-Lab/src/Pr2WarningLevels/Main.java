package Pr2WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String level = reader.readLine();
        Logger logger = new Logger(Importance.valueOf(level.toUpperCase()));
        while (true) {
            String input = reader.readLine();
            String[] line = input.split(":\\s+");
            if ("END".equals(line[0])) {
                break;
            }
            Message message = new Message(input, Importance.valueOf(line[0].toUpperCase()));
            logger.receiveMessage(message);
        }
        for (Message message : logger.getMessages()) {
            System.out.println(message.getMessage());
        }
    }
}
