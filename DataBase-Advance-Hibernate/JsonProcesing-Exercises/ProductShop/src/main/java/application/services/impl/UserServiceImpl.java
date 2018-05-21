package application.services.impl;

import application.entities.User;
import application.repositories.UserRepository;
import application.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Primary
public class UserServiceImpl implements UserService<User, Long>{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    @Override
    public void saveList(List<User> objects) {
        this.userRepository.save(objects);
    }

    @Override
    public Set<User> successfullySoldProducts() {
        return this.userRepository.successfullySoldProducts();
    }

    @Override
    public Set<User> userAndProducts() {
        return this.userRepository.userAndProducts();
    }
}
