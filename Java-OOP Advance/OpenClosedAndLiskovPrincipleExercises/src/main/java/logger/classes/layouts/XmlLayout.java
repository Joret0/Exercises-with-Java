package logger.classes.layouts;

import logger.interfaces.Layout;

public class XmlLayout implements Layout{
    private final String format = "<log>%n\t<date>%s</date>%n\t<level>%s</level>%n\t<message>%s</message>%n</log>";

    @Override
    public String getFormat() {
        return this.format;
    }
}
