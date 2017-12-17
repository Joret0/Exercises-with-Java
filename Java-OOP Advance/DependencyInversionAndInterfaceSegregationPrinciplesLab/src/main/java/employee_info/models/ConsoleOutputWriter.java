package employee_info.models;

import system_resources.interfaces.Writer;

public class ConsoleOutputWriter implements Writer{
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
