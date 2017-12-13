package logger.classes.layouts;

import logger.interfaces.Layout;

public class SimpleLayout implements Layout{
    private final String format = "%s - %s - %s";

    @Override
    public String getFormat() {
        return this.format;
    }
}
