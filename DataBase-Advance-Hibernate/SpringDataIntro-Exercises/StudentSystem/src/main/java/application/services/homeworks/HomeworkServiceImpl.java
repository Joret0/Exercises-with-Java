package application.services.homeworks;

import application.models.Homework;
import application.repositories.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class HomeworkServiceImpl implements HomeworkService<Homework, Long> {
    private HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public Homework findById(Long id) {
        return this.homeworkRepository.findOne(id);
    }

    @Override
    public void remove(Homework object) {
        this.homeworkRepository.delete(object);
    }

    @Override
    public List<Homework> findAll() {
        return this.homeworkRepository.findAll();
    }

    @Override
    public void save(Homework object) {
        this.homeworkRepository.save(object);
    }

    @Override
    public List<Homework> findAllByStudentId(Long id) {
        return this.homeworkRepository.findAllByStudentId(id);
    }
}
