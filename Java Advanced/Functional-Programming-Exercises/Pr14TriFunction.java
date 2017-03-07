import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class Pr14TriFunction {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberToReach = Integer.parseInt(reader.readLine());
        ArrayList<String> names = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));
        String resultOfFunctions = triFunction.apply(numberToReach, biFunction, names);
        if (resultOfFunctions != null) {
            System.out.println(resultOfFunctions);
        }
        reader.close();
    }
    private static TriFunction<Integer, BiFunction<String, Integer, Boolean>, ArrayList<String>, String> triFunction = (number, bifunc, nameList) -> {
        for (String name : nameList) {
            if (bifunc.apply(name, number)) {
                return name;
            };
        }
        return null;
    };
    private static BiFunction<String, Integer, Boolean> biFunction = (string, number) -> {
        int sum = 0;
        for (char letter : string.toCharArray()) {
            sum += letter;
        }
        return sum >= number;
    };
}
@FunctionalInterface
interface TriFunction<A,B,C,R> {
    R apply(A integer, B biFunction, C arrayList);
}