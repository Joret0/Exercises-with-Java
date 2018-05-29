package application.services.api;

import application.models.Game;

import java.util.List;
import java.util.Set;

public interface UserService<User, Long> extends Service<User, Long>{
    User findUserByEmailAndPassword(String email, String password);
    List<User> findUserByIsLoggedInTrue();
    Set<Game> getGameFromUser(String gameTitle, Long id);
}
