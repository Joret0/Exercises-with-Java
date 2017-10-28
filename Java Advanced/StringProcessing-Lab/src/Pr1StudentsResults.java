import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr1StudentsResults {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" - ");
        String studentName = input[0];
        String[] grades = input[1].split(", ");
        double gradeJavaAdvance = Double.parseDouble(grades[0]);
        double gradeJavaOOP = Double.parseDouble(grades[1]);
        double gradeAdvOOP = Double.parseDouble(grades[2]);
        double gradeAverage = (gradeJavaAdvance + gradeJavaOOP + gradeAdvOOP) / 3;

        String table = String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        String tableStudentResults = String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", studentName, gradeJavaAdvance, gradeJavaOOP, gradeAdvOOP, gradeAverage);
        System.out.println(table);
        System.out.println(tableStudentResults);
    }
}
