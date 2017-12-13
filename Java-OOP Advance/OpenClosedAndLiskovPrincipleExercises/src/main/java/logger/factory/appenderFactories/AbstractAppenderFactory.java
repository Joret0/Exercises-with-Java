package logger.factory.appenderFactories;

import logger.classes.LogFile;
import logger.classes.appenders.ConsoleAppender;
import logger.classes.appenders.FileAppender;
import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.IAppenderFactory;
import logger.interfaces.Layout;
import logger.utils.Constants;

public class AbstractAppenderFactory implements IAppenderFactory{

    @Override
    public Appender getAppender(String type, Layout layout, ReportLevel level) {
        if (type.equals(Constants.CONSOLE_APPENDER)) {
            return new ConsoleAppender(layout, level);
        } else if (type.equals(Constants.FILE_APPENDER)) {
            FileAppender fileAppender = new FileAppender(layout, level);
            fileAppender.setFile(new LogFile());
            return fileAppender;
        }
        return null;
    }
}
