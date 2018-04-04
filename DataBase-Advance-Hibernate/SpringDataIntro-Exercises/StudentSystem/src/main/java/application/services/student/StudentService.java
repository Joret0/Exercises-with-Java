package application.services.student;

import application.services.base.BaseService;

import java.util.Date;
import java.util.List;

public interface StudentService<Student, Long> extends BaseService<Student, Long>{

    List<Object[]> getStudentInfo();

    Student findByName(String name);

    List<Student> findAllByRegistrationDateAfter(Date date);
}
