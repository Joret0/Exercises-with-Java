package integration;

import javax.jws.soap.SOAPBinding;
import javax.naming.OperationNotSupportedException;
import java.util.Set;

public class Category {

    private String name;
    private Set<User> users;
    private Set<Category> categories;

    public Category(String name, Set<User> users, Set<Category> categories) {
        this.name = name;
        this.users = users;
        this.categories = categories;
    }

    public void assign(User user) throws OperationNotSupportedException {
        if (user == null) {
            throw new OperationNotSupportedException("User is null.");
        }
        this.users.add(user);
    }

    public void assign(Category category) throws OperationNotSupportedException {
        if (category == null) {
            throw new OperationNotSupportedException("Category is null.");
        }
        this.categories.add(category);
    }

    public String getName() {
        return this.name;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }
}
