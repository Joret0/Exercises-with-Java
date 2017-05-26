package Pr9IncreaseAgeStoredProcedure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class IncreaseAgeStoredProcedure {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(reader.readLine());
        String query = String.format("CALL usp_increase_age (%d)", id);
        try(
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                CallableStatement statement = connection.prepareCall(query);
                ) {

            statement.execute();
            query = "SELECT name, age FROM minions WHERE minion_id = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            String result = resultSet.next() ? resultSet.getString("name") + " " + resultSet.getInt("age") : null;
            System.out.println(result == null ? "No such minion" : result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
