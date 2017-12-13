package logger.interfaces;

import logger.enums.ReportLevel;

public interface Appender {
    ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    void setReportLevel(ReportLevel level);
    void appendMessage(ReportLevel error, String dateAndTime, String message);
    ReportLevel getLevel();
    Layout getLayout();
}
