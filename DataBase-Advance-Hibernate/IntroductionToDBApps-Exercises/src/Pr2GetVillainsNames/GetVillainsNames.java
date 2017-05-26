package Pr2GetVillainsNames;

import java.sql.*;

public class GetVillainsNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {

        String query = "SELECT v.villain_name,COUNT(vm.minion_id) AS minion_count FROM villains AS v" +
                " JOIN villains_minions AS vm ON v.villain_id = vm.villain_id\n" +
                " GROUP BY v.villain_id\n" +
                " ORDER BY minion_count DESC; ";
        StringBuilder builder = new StringBuilder();
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);) {

            while (resultSet.next()) {
                String name = resultSet.getString("villain_name");
                int count = resultSet.getInt("minion_count");
                builder.append(String.format("%s %d", name, count));
                builder.append(System.lineSeparator());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (builder.length() > 0) {
            System.out.println(builder.toString());
        }
    }
}
