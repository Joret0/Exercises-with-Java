import connection.DatabaseConnection;
import entities.User;
import orm.EntityManager;

import java.sql.SQLException;
import java.util.Date;

public class DemoORM {

    public static void main(String[] args) {

        try {
            EntityManager entityManager = new EntityManager(DatabaseConnection.getConnection());
            User user = new User("Georgi23", 27, new Date());
            user.setId(1);
            entityManager.persist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
