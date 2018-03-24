package application.repositories;

import application.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
    @Override
    Iterable<Account> findAll(Iterable<Long> iterable);

    @Override
    Account findOne(Long aLong);
}
