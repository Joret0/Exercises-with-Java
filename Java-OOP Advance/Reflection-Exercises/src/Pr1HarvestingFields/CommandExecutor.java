package Pr1HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;


public class CommandExecutor implements ICommandExecutor{
    @Override
    public void execute(String command) {
        switch (command) {
            case "private":
                this.printFields(Arrays.stream(RichSoilLand.class.getDeclaredFields()).filter(m -> Modifier.isPrivate(m.getModifiers())));
                break;
            case "protected":
                this.printFields(Arrays.stream(RichSoilLand.class.getDeclaredFields()).filter(m -> Modifier.isProtected(m.getModifiers())));
                break;
            case "public":
                this.printFields(Arrays.stream(RichSoilLand.class.getDeclaredFields()).filter(m -> Modifier.isPublic(m.getModifiers())));
                break;
            case "all":
                this.printFields(Arrays.stream(RichSoilLand.class.getDeclaredFields()));
                break;
        }
    }

    @Override
    public void printFields(Stream<Field> fieldStream) {
        fieldStream.forEach(f -> System.out.println(String.format("%s %s %s", convertModifierToString(f.getModifiers()), f.getType().getSimpleName(), f.getName())));
    }

    private String convertModifierToString(int modifiers) {
        switch (modifiers) {
            case 1:
                return "public";
            case 2:
                return "private";
            case 4:
                return "protected";
            default:
                return "";
        }
    }
}
