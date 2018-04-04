package application.repositories;

import application.models.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long>{
    List<Homework> findAllByStudentId(Long id);
}
