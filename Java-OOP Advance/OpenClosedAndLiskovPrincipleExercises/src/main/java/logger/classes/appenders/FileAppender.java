package logger.classes.appenders;

import logger.enums.ReportLevel;
import logger.interfaces.File;
import logger.interfaces.Layout;

public class FileAppender extends BaseAppender{
    private File file;

    public FileAppender(Layout layout, ReportLevel level) {
        super(layout, level);
    }

    @Override
    public void appendMessage(ReportLevel error, String dateAndTime, String message) {
        if (super.getLevel().ordinal() <= error.ordinal()) {
            String formattedMessage = String.format(super.getLayout().getFormat(), dateAndTime, error.name(), message);
            this.file.write(formattedMessage);
            super.messagesCount++;
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format(", File size: %d", this.file.getSize()));
    }
}
