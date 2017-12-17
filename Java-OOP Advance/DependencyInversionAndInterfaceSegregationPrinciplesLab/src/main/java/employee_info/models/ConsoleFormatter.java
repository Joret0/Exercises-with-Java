package employee_info.models;

import employee_info.interfaces.Formatter;
import employee_info.interfaces.Human;

public class ConsoleFormatter implements Formatter{
    @Override
    public String format(Iterable<Human> employees) {
        StringBuilder builder = new StringBuilder();
        for (Human employee : employees) {
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
