package application.services.api;

import java.util.Set;

public interface UserService<User, Long> extends Service<User, Long>{
    Set<User> successfullySoldProducts();
    Set<User> userAndProducts();
}
