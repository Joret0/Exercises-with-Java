import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pr27AverageGrades {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(" ");
            String name = info[0];
            List<Double> grades = new ArrayList<>();
            MakesStudents(grades, info, name, students);
        }
        PrintStudents(students);
    }

    private static void PrintStudents(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                String x1 = ((Student) o1).getName();
                String x2 = ((Student) o2).getName();
                int comp = x1.compareTo(x2);

                if (comp != 0) {
                    return comp;
                } else {
                    Double y1 = ((Student) o2).getGrade();
                    Double y2 = ((Student) o1).getGrade();
                    return y1.compareTo(y2);
                }
            }
        });
        for (Student student : students) {
            System.out.printf("%s -> %.2f%n", student.getName(), student.getGrade());
        }
    }

    private static void MakesStudents(List<Double> grades, String[] info, String name, List<Student> students) {
        for (int i = 1; i < info.length; i++) {
            grades.add(Double.parseDouble(info[i]));
        }
        Double averageGrade = grades.stream().mapToDouble(v -> v).average().getAsDouble();
        if (averageGrade >= 5) {
            Student student = new Student(averageGrade, name);
            students.add(student);
        }
    }
}

class Student {
    private Double grade;
    private String name;

    public Student(Double grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
