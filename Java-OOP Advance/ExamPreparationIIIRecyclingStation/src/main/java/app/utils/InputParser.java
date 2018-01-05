package app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser implements Parser{
    private static final String DELIMITER = "[\\s+|]";

    public InputParser() {
    }

    @Override
    public List<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split(DELIMITER)));
    }

    @Override
    public String[] parseInputAsArray(String inputLine) {
        String[] split = inputLine.split(DELIMITER);
        String[] split1 = inputLine.split(DELIMITER);
        int i = 0;
        for (String s : split) {
            if (!s.isEmpty()) {
                split1[i++] = s;
            }
        }

        return split1;
    }

}
