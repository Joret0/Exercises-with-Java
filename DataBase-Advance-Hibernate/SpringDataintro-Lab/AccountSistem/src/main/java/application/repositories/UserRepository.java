package application.repositories;

import application.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    @Override
    User findOne(Long aLong);

    User getByUserName(String userName);
}
