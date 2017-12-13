package integration_test;

import integration.Category;
import integration.User;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CategoryTest {

    @Test(expected = OperationNotSupportedException.class)
    public void assignUserThrowsException() throws OperationNotSupportedException {
        User user = null;
        Set<User> users = new LinkedHashSet<>();
        Set<Category> categories = new LinkedHashSet<>();
        Category category = new Category("Some name", users, categories);
        category.assign(user);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void assignCategoryThrowsException() throws OperationNotSupportedException {
        Category categoryToAssign = null;
        Set<User> users = new LinkedHashSet<>();
        Set<Category> categories = new LinkedHashSet<>();
        Category category = new Category("Some name", users, categories);
        category.assign(categoryToAssign);
    }
}
