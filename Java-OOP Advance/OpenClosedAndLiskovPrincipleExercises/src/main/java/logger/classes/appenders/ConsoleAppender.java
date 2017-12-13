package logger.classes.appenders;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;
import logger.io.ConsoleOutputWriter;

public class ConsoleAppender extends BaseAppender{

    public ConsoleAppender(Layout layout, ReportLevel level) {
        super(layout, level);
    }

    @Override
    public void appendMessage(ReportLevel error, String dateAndTime, String message) {
        if (super.getLevel().ordinal() <= error.ordinal()) {
            String formattedMessage = String.format(super.getLayout().getFormat(), dateAndTime, error.name(), message);
            ConsoleOutputWriter.writeLine(formattedMessage);
            super.messagesCount++;
        }
    }
}
