package application.services.api;

import application.models.User;

import java.util.List;
import java.util.Set;

public interface GameService<Game, Long> extends Service<Game, Long>{
    Game findGameByTitle(String title);
    List<Game> findGameByOwners(Set<User> owners);
}
