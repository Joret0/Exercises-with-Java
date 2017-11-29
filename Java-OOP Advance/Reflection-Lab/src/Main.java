import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        //task_1();

        //task_2();

        task_3();

    }

    private static void task_3() {
        Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(String.format("%s must be private!", f.getName())));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .forEach(m -> System.out.println(String.format("%s have to be public!", m.getName())));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .forEach(m -> System.out.println(String.format("%s have to be private!", m.getName())));
    }

    private static void task_2() {
        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s will return %s", m.getName(), m.getReturnType())));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s and will set field of %s", m.getName(), m.getParameterTypes()[0])));
    }

    private static void task_1() throws IllegalAccessException, InstantiationException {
        Class aClass = Reflection.class;
        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());
        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Reflection ref = (Reflection) aClass.newInstance();
        System.out.println(ref);
    }
}
