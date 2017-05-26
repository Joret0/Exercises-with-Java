package Pr5ChangeTownNamesCasing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ChangeTownNamesCasing {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ) {

            String query = String.format("SELECT name FROM towns WHERE country_name = '%s'", country);
            ResultSet resultSet = statement.executeQuery(query);
            List<String> towns = new LinkedList<>();
            while (resultSet.next()) {
                String townName = resultSet.getString("name");
                if (!isUpperCase(townName)) {
                    towns.add(townName.toUpperCase());
                }
            }
            query = String.format("UPDATE towns SET name = UPPER(name) WHERE country_name = '%s'", country);
            statement.execute(query);

            stringBuilder.append(towns.isEmpty() ? "No town names were affected." :
                    String.format("%d town names were affected.\n%s\n", towns.size(), towns));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());
    }

    private static boolean isUpperCase(String townName) {
        for (char c : townName.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
