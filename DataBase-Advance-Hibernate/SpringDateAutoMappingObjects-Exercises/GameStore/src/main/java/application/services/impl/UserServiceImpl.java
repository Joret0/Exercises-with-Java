package application.services.impl;

import application.models.Game;
import application.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.UserRepository;
import application.services.api.UserService;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService<User, Long>{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return this.userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public List<User> findUserByIsLoggedInTrue() {
        return this.userRepository.findUserByIsLoggedInTrue();
    }

    @Override
    public Set<Game> getGameFromUser(String gameTitle, Long id) {
        return this.userRepository.getGameFromUser(gameTitle, id);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public void remove(User object) {
        this.userRepository.delete(object);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void save(User object) {
        this.userRepository.save(object);
    }
}
