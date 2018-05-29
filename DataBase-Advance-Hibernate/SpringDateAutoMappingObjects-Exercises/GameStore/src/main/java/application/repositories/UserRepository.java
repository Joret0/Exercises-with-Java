package application.repositories;

import application.models.Game;
import application.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findUserByEmailAndPassword(String email, String password);
    List<User> findUserByIsLoggedInTrue();
    @Query("select g from User u inner join u.games g where g.title = :title and u.id=:id")
    Set<Game> getGameFromUser(@Param(value = "title") String gameTitle, @Param(value = "id") Long id);
}
