package app.repositories;

import app.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("select u from User u inner join u.soldProducts s where s.buyer is not null " +
            "group by s.seller\n" +
            "having count(s.seller) > 1\n" +
            " order by u.lastName asc, u.firstName asc")
    Set<User> successfullySoldProducts();

    @Query("select p.seller from Product p where p.buyer is not null " +
            "group by p.seller " +
            "order by count(p.seller.soldProducts.size) desc, p.seller.firstName")
    Set<User> usersAndProducts();
}
