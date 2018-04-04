package application.services.course;

import application.models.Course;
import application.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class CourseServiceImpl implements CourseService<Course, Long>{
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<String> getCourseWithMoreThan5Resourses() {
        return this.courseRepository.getCourseWithMoreThan5Resources();
    }

    @Override
    public List<Course> activeCourses2001() {
        return this.courseRepository.activeCources2001();
    }

    @Override
    public List<Course> findAllByStartDate(Date date) {
        return this.courseRepository.findAllByStartDate(date);
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findOne(id);
    }

    @Override
    public void remove(Course object) {
        this.courseRepository.delete(object);
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public void save(Course object) {
        this.courseRepository.save(object);
    }
}