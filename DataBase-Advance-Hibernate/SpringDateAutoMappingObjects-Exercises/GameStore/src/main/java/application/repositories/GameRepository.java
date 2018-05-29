package application.repositories;

import application.models.Game;
import application.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
    Game findGameByTitle(String title);
    List<Game> findGameByOwners(Set<User> owners);
}
