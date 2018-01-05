package app.utils;

import java.util.List;

public interface Parser {
    List<String> parseInput(String inputLine);

    String[] parseInputAsArray(String inputLine);
}
