package Pr5CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> authorMethods = new HashMap<>();
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                authorMethods.putIfAbsent(annotation.name(), new ArrayList<>());
                authorMethods.get(annotation.name()).add(method.getName());
            }
        }
        for (Map.Entry<String, List<String>> entry : authorMethods.entrySet()) {
            System.out.printf("%s: %s()%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
