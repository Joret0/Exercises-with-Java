package Pr6RemoveVillain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RemoveVillain {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.parseInt(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ) {
            String query = "SELECT COUNT(*) as c FROM villains_minions WHERE villain_id = " + villainId;
            ResultSet resultSet = statement.executeQuery(query);
            int count = resultSet.next() ? resultSet.getInt("c") : 0;
            query = "SELECT villain_name FROM villains WHERE villain_id = " + villainId;
            resultSet = statement.executeQuery(query);
            String villainName = resultSet.next() ? resultSet.getString("villain_name") : null;
            query = "DELETE FROM villains_minions WHERE villain_id = " + villainId;
            statement.executeUpdate(query);
            query = "DELETE FROM villains WHERE villain_id = " + villainId;
            statement.executeUpdate(query);
            String minions = count == 1 ? "1 minion released" : count + " minions released";
            stringBuilder.append(villainName == null ? "No such villain found" : String.format("%s was deleted\n%s", villainName, minions));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder);
    }
}
