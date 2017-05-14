package Pr3.AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Field> fields = Arrays.asList(Chicken.class.getDeclaredFields());
        List<Method> methods = Arrays.asList(Chicken.class.getDeclaredMethods());
        assert fields.stream().filter(field -> Modifier.isPrivate(field.getModifiers())).count() == 4;
        assert methods.stream().filter(method -> Modifier.isPrivate(method.getModifiers())).count() == 1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.printf("Chicken %s (age %d) can produce %.0f eggs per day.", chicken.getName(), chicken.getAge(), chicken.getProductPerDay());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
