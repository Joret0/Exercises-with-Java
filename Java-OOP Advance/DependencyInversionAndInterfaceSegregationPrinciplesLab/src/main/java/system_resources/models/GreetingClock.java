package system_resources.models;

import system_resources.interfaces.TimeProvider;
import system_resources.interfaces.Writer;

public class GreetingClock {
    private static final String GOOD_MORNING_GREETING = "Good morning...";
    private static final String GOOD_AFTERNOON_GREETING = "Good afternoon...";
    private static final String GOOD_EVENING_GREETING = "Good evening...";

    private TimeProvider time;
    private Writer writer;

    public GreetingClock(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    public void greeting() {
        if (time.getHour() < 12) {
            this.writer.writeLine(GOOD_MORNING_GREETING);
        } else if (time.getHour() < 18) {
            this.writer.writeLine(GOOD_AFTERNOON_GREETING);
        } else {
            this.writer.writeLine(GOOD_EVENING_GREETING);
        }
    }
}
