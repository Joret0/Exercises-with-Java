package logger.commands;

import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.IAppenderFactory;
import logger.interfaces.ILayoutFactory;
import logger.interfaces.Layout;

import java.util.List;

public class CommandInterpreter {
    private IAppenderFactory appenderFactory;
    private ILayoutFactory layoutFactory;

    public CommandInterpreter(IAppenderFactory appenderFactory, ILayoutFactory layoutFactory) {
        this.appenderFactory = appenderFactory;
        this.layoutFactory = layoutFactory;
    }

    public Appender interpretAppenderCommand(String... params) {
        String appenderType = params[0];
        String layoutType = params[1];
        ReportLevel level = null;
        try {
            level = ReportLevel.valueOf(params[2]);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        Layout layout = this.layoutFactory.getLayout(layoutType);
        return this.appenderFactory.getAppender(appenderType, layout, level);
    }

    public Object[] interpretMessageCommand(List<String> messages) {
        ReportLevel level = ReportLevel.valueOf(messages.remove(0));
        String dateAndTime = messages.remove(0);
        String msg = messages.remove(0);

        return new Object[]{level, dateAndTime, msg};
    }
}
