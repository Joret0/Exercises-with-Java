package application.services.course;

import application.services.base.BaseService;

import java.util.Date;
import java.util.List;

public interface CourseService<Course, Long> extends BaseService<Course, Long>{

    List<String> getCourseWithMoreThan5Resourses();
    List<Course> activeCourses2001();
    List<Course> findAllByStartDate(Date date);
}
