import entities.Course;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("universitydb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Course course = new Course("Hibernate", LocalDate.of(2018, 6, 24), LocalDate.of(2018, 8, 13), 15);
        Course secondCourse = new Course("Spring", LocalDate.of(2018, 9, 1), LocalDate.of(2018, 12, 21), 28);

        Teacher teacher = new Teacher("teacher@abv.bg", new BigDecimal(20));
        teacher.setFirstName("Ivan");
        teacher.setLastName("Stalev");
        teacher.setPhoneNumber("0123456789");

        course.setTeacher(teacher);
        secondCourse.setTeacher(teacher);

        Set<Course> courses = new HashSet<>();
        courses.add(course);
        courses.add(secondCourse);

        Student student = new Student(new BigDecimal(6.00), 10);
        student.setFirstName("Georgi");
        student.setLastName("Stalev");
        student.setPhoneNumber("0123456789");
        student.setCourses(courses);

        Student student2 = new Student(new BigDecimal(5.50), 10);
        student2.setFirstName("Ivan");
        student2.setLastName("Georgiev");
        student2.setPhoneNumber("0123456789");
        student2.setCourses(courses);

        em.persist(teacher);
        em.persist(course);
        em.persist(secondCourse);
        em.persist(student);
        em.persist(student2);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
