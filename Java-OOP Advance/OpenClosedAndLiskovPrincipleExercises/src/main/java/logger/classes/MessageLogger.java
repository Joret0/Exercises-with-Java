package logger.classes;

import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Logger;

import java.util.Arrays;

public class MessageLogger implements Logger{

    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    private void log(ReportLevel level, String dateAndTime, String message) {
        Arrays.stream(this.appenders).forEach(x -> x.appendMessage(level, dateAndTime, message));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(this.appenders).forEach(x -> builder.append(x.toString()).append(System.lineSeparator()));
        return builder.toString();
    }

    @Override
    public void logInfo(String dateAndTime, String message) {
        this.log(ReportLevel.INFO, dateAndTime, message);
    }

    @Override
    public void logWarning(String dateAndTime, String message) {
        this.log(ReportLevel.WARNING, dateAndTime, message);
    }

    @Override
    public void logError(String dateAndTime, String message) {
        this.log(ReportLevel.ERROR, dateAndTime, message);
    }

    @Override
    public void logCritical(String dateAndTime, String message) {
        this.log(ReportLevel.CRITICAL, dateAndTime, message);
    }

    @Override
    public void logFatal(String dateAndTime, String message) {
        this.log(ReportLevel.FATAL, dateAndTime, message);
    }

    @Override
    public void logLevel(ReportLevel level, String dateAndTime, String message) {
        switch (level) {
            case CRITICAL:
                this.logCritical(dateAndTime, message);
                break;
            case ERROR:
                this.logError(dateAndTime, message);
                break;
            case FATAL:
                this.logFatal(dateAndTime, message);
                break;
            case WARNING:
                this.logWarning(dateAndTime, message);
                break;
            case INFO:
                this.logInfo(dateAndTime, message);
                break;
        }
    }

    private void setAppendersReportLevel(ReportLevel level) {
        Arrays.stream(this.appenders).forEach(x -> x.setReportLevel(level));
    }
}
