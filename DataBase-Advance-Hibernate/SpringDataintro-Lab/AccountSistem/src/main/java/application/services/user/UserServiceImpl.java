package application.services.user;

import application.models.User;
import application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        Long id = user.getId();
        if (id != null) {
            if (this.userRepository.exists(id)) {
                throw new RuntimeException("This user already exist!");
            }
        }
        String username = user.getUserName();
        if (username != null) {
            User newUser = this.userRepository.getByUserName(username);
            if (newUser != null) {
                throw new RuntimeException("This username already exist!");
            }
        }
        this.userRepository.save(user);
    }
}
