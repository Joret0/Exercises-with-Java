package logger.io;

import logger.interfaces.IConsoleInputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements IConsoleInputReader{
    private BufferedReader reader;

    public ConsoleInputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String result = null;

        try {
            result = this.reader.readLine();
        } catch (IOException e) {

        }
        return result;
    }
}
