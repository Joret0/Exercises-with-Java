package application.services.homeworks;

import application.models.Homework;
import application.services.base.BaseService;

import java.util.List;

public interface HomeworkService<Homework, Long> extends BaseService<Homework, Long>{

    List<Homework> findAllByStudentId(Long id);
}
