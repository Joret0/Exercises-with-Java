package logger.interfaces;

import logger.enums.ReportLevel;

public interface IRepository {
    void initializeLogger(Appender... appenders);
    void putMessageInLogger(ReportLevel level, String dateAndTime, String message);
    void print();
}
