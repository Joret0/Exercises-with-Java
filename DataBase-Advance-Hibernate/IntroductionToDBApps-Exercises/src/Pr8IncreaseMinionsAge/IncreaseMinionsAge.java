package Pr8IncreaseMinionsAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class IncreaseMinionsAge {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayID = bufferedReader.readLine().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        try(
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ) {

            String query = String.format("UPDATE minions SET age = age + 1, name = CONCAT(UPPER(LEFT(name,1)), " +
                    "SUBSTRING(name, 2)) WHERE minion_id IN (%s);", Arrays.toString(arrayID).replaceAll("[\\[\\]]", ""));
            statement.execute(query);
            query = "SELECT name, age FROM minions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                stringBuilder.append(name).append(" ").append(age);
                stringBuilder.append(System.lineSeparator());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder);
    }
}
