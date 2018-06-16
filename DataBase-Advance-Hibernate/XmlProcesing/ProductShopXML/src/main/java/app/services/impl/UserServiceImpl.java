package app.services.impl;

import app.modules.User;
import app.repositories.UserRepository;
import app.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Set<User> successfullySoldProducts() {
        return this.userRepository.successfullySoldProducts();
    }

    @Override
    public Set<User> usersAndProducts() {
        return this.userRepository.usersAndProducts();
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
    public void saveList(List<User> object) {
        this.userRepository.save(object);
    }
}
