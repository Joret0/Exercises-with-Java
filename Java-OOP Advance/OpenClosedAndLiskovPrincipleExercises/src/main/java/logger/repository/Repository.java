package logger.repository;

import logger.classes.MessageLogger;
import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.IRepository;
import logger.interfaces.Logger;
import logger.io.ConsoleOutputWriter;
import logger.utils.Constants;

public class Repository implements IRepository{
    private Logger logger;

    @Override
    public void initializeLogger(Appender... appenders) {
        this.logger = new MessageLogger(appenders);
    }

    @Override
    public void putMessageInLogger(ReportLevel level, String dateAndTime, String message) {
        this.logger.logLevel(level, dateAndTime, message);
    }

    @Override
    public void print() {
        ConsoleOutputWriter.writeLine(Constants.LOGGER_INFO);
        System.out.println(this.logger);
    }
}
