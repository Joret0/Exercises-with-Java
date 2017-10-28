import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Pr6AcademyGraduation {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> studentsInfo = new HashMap<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String name = bufferedReader.readLine();
            double[] grades = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            double sum = 0;
            for (int j = 0; j < grades.length; j++) {
                sum += grades[j];
            }
            double avgGrade = sum / grades.length;
            studentsInfo.put(name, avgGrade);
        }
        for (Map.Entry<String, Double> entry : studentsInfo.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }
}
