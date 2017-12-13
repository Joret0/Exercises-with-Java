package logger.utils;

import logger.interfaces.IInputParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser implements IInputParser{
    private static final String SPACE_DELIMITER = "\\s+";
    private static final String LINE_DELIMITER = "\\|";

    public InputParser() {
    }

    @Override
    public List<String> parseInput(String inputLine) {
        return new ArrayList<String>(Arrays.asList(inputLine.split(LINE_DELIMITER)));
    }

    @Override
    public String[] parseInputAsArray(String inputLine) {
        return inputLine.split(SPACE_DELIMITER);
    }
}
