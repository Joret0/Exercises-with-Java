package application.services.student;

import application.models.Student;
import application.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class StudentServiceImpl implements StudentService<Student, Long>{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Object[]> getStudentInfo() {
        return this.studentRepository.getStudentInfo();
    }

    @Override
    public Student findByName(String name) {
        return this.studentRepository.findByName(name);
    }

    @Override
    public List<Student> findAllByRegistrationDateAfter(Date date) {
        return this.studentRepository.findAllByRegistrationDateAfter(date);
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findOne(id);
    }

    @Override
    public void remove(Student object) {
        this.studentRepository.delete(object);
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void save(Student object) {
        this.studentRepository.save(object);
    }
}
