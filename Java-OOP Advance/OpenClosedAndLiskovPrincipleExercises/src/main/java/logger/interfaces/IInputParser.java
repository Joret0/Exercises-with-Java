package logger.interfaces;

import java.util.List;

public interface IInputParser {
    List<String> parseInput(String inputLine);
    String[] parseInputAsArray(String inputLine);
}
