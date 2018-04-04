package application.console;

import application.enums.ContentType;
import application.enums.ResourceType;
import application.models.*;
import application.services.course.CourseServiceImpl;
import application.services.homeworks.HomeworkServiceImpl;
import application.services.licence.LicenceServiceImpl;
import application.services.resources.ResourceServiceImpl;
import application.services.student.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner{
    private StudentServiceImpl studentService;
    private CourseServiceImpl courseService;
    private HomeworkServiceImpl homeworkService;
    private ResourceServiceImpl resourceService;
    private LicenceServiceImpl licenceService;

    @Autowired
    public ConsoleRunner(StudentServiceImpl studentService, CourseServiceImpl courseService, HomeworkServiceImpl homeworkService, ResourceServiceImpl resourceService, LicenceServiceImpl licenceService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.homeworkService = homeworkService;
        this.resourceService = resourceService;
        this.licenceService = licenceService;
    }

    @Override
    public void run(String... strings) throws Exception {
        seedData();
    //    tasks();
    }

    private void tasks() {
        //1.
        this.homeworkService.findAll()
                .stream()
                .forEach(x -> System.out.printf("%s %s %s%n", x.getStudent().getName(), x.getContent(), x.getContentType().toString()));

        //2.
        List<Course> courses = this.courseService.findAll();
        courses = courses.stream()
                .sorted(Comparator.comparing(Course::getStartDate)
                .thenComparing(Course::getEndDate)
                        .reversed()).collect(Collectors.toList());

        for (Course course : courses) {
            System.out.printf("%s %s %s%n", course.getName(), course.getDescription(), course.getPrice());
            for (Resource resource : course.getResources()) {
                System.out.printf("%s %s %s%n", resource.getName(), resource.getResourceType(), resource.getUrl());
            }
            System.out.println("___________________________________________");
        }

        //3.
        this.courseService.getCourseWithMoreThan5Resourses().forEach(System.out::println);

        //4.
        this.courseService.activeCourses2001()
                .stream()
                .sorted(Comparator.comparing((Course course) -> course.getStudents().size()).reversed()
                .thenComparing(Course::getDifferentDays).reversed())
                .forEach(x -> System.out.printf("%s %s %s %s %s%n",
                        x.getName(),
                        x.getStartDate().toString(),
                        x.getEndDate().toString(),
                        x.getDifferentDays(),
                        x.getStudents().size()));

        //5.
        this.studentService.getStudentInfo().forEach(s -> {
            System.out.printf("Name: %s, Course count: %s, Total price: %s, Average price: %s%n",
                    s[0], s[1], s[2], s[3]);
        });
    }

    private void seedData() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

        //Set<Student> students = new HashSet<>();

        Student student1 = new Student();
        student1.setName("Georgi");
        student1.setRegistrationDate(new Date());
        student1.setPhone("0123456789");
        //this.studentService.save(student1);

        Student student2 = new Student();
        student2.setName("Aneta");
        student2.setRegistrationDate(dateFormat.parse("08/09/2005"));
        student2.setPhone("0123456789");
        //this.studentService.save(student2);

        //students.add(student1);
        //students.add(student2);

        //Set<Course> courses = new HashSet<>();

        Course course1 = new Course();
        course1.setName("Java OOP");
        course1.setStartDate(dateFormat.parse("20/10/2006"));
        course1.setEndDate(dateFormat.parse("20/11/2006"));
        course1.setPrice(new BigDecimal(360));
        course1.setDescription("Principles of the Objec Orienting programing");
        //courses.add(course1);
        //course1.setStudents(students);
        //this.courseService.save(course1);

        Course course2 = new Course();
        course2.setName("Spring Framework");
        course2.setStartDate(dateFormat.parse("20/11/2006"));
        course2.setEndDate(dateFormat.parse("20/12/2006"));
        course2.setPrice(new BigDecimal(360));
        course2.setDescription("Spring Framework");
        //courses.add(course2);
        //course2.setStudents(students);
        //this.courseService.save(course2);

        student1.setCourses(new HashSet<Course>(){{
            add(course1);
            add(course2);
        }});
        student2.setCourses(new HashSet<Course>(){{
            add(course1);
            add(course2);
        }});
        this.studentService.save(student1);
        this.studentService.save(student2);

        course1.setStudents(new HashSet<Student>() {{
            add(student1);
            add(student2);
        }});
        course1.setStudents(new HashSet<Student>() {{
            add(student1);
            add(student2);
        }});
        this.courseService.save(course1);
        this.courseService.save(course2);

        Homework homework1 = new Homework();
        homework1.setContent("Some student work");
        homework1.setContentType(ContentType.APPLICATION_PDF);
        homework1.setSubmissionDate(new Date());
        homework1.setStudent(student1);
        homework1.setCourse(course1);
        this.homeworkService.save(homework1);

        Homework homework2 = new Homework();
        homework2.setContent("Some student work");
        homework2.setContentType(ContentType.APPLICATION_PDF);
        homework2.setSubmissionDate(new Date());
        homework2.setStudent(student2);
        homework2.setCourse(course2);
        this.homeworkService.save(homework2);

        Resource resource1 = new Resource();
        resource1.setName("Java");
        resource1.setResourceType(ResourceType.PRESENTATION);
        resource1.setCourse(course1);
        resource1.setUrl("www.java.baraime4a.com");
        this.resourceService.save(resource1);

        Resource resource2 = new Resource();
        resource2.setName("Java Spring");
        resource2.setResourceType(ResourceType.VIDEO);
        resource2.setCourse(course2);
        resource2.setUrl("www.java.baraime4a2ra4ast.com");
        this.resourceService.save(resource2);

        License license1 = new License();
        license1.setName("Ima nqma");
        license1.setResource(resource1);
        this.licenceService.save(license1);

        License license2 = new License();
        license2.setName("6to e to");
        license2.setResource(resource2);
        this.licenceService.save(license2);
    }
}
