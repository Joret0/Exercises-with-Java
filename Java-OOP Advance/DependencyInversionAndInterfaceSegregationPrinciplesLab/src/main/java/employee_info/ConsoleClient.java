package employee_info;

import employee_info.interfaces.Database;
import employee_info.interfaces.Formatter;
import employee_info.interfaces.InfoProvider;
import employee_info.models.ConsoleFormatter;
import employee_info.models.ConsoleOutputWriter;
import employee_info.models.EmployeeDatabase;
import employee_info.models.EmployeeInfoProvider;
import system_resources.interfaces.Writer;

public class ConsoleClient {
    public static void main(String[] args) {
        Database database = new EmployeeDatabase();
        InfoProvider employeeInfo = new EmployeeInfoProvider(database);
        Formatter formatter = new ConsoleFormatter();
        String output = formatter.format(employeeInfo.getByName());
        Writer writer = new ConsoleOutputWriter();
        writer.writeLine(output);
    }
}
