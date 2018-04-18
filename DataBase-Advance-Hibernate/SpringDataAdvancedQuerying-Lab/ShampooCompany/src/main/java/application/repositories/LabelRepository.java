package application.repositories;

import application.model.labels.BasicLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<BasicLabel, Long>{

    @Override
    BasicLabel findOne(Long aLong);
}
