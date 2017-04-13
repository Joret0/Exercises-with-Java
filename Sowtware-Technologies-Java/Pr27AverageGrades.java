import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pr27AverageGrades {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> input = Arrays.asList(reader.readLine().split("\\s+"));
            String name = input.get(0);
            input.remove(0);
            Student student = new Student();
            student.setName(name);
            student.setGrades(input.stream().map(Double::parseDouble).collect(Collectors.toList()));
            double sum = student.getGrades().stream().mapToDouble(d -> d).sum();
            student.setAverageGrade(sum / student.getGrades().size());
            studentList.add(student);
        }

        Comparator<Student> byName = (n1, n2) -> n1.getName().compareTo(n2.getName());

        studentList = (List<Student>) studentList.stream().filter(s -> s.getAverageGrade() >= 5).sorted(Comparator.comparing(Student::getName));

        for (int i = 0; i < studentList.size(); i++) {
            System.out.printf("%s -> %d%n", studentList.get(i).getName(), studentList.get(i).getAverageGrade());
        }
    }
}

class Student {
    private String Name;
    private List<Double> Grades;
    private double AverageGrade;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Double> getGrades() {
        return Grades;
    }

    public void setGrades(List<Double> grades) {
        Grades = grades;
    }

    public double getAverageGrade() {
        return AverageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        AverageGrade = averageGrade;
    }
}
