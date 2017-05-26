package Pr3GetMinionNames;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class GetMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.parseInt(reader.readLine());
        String query = String.format(
                "SELECT villain_name,m.name,m.age FROM villains_minions AS vm\n" +
                        " JOIN minions AS m ON m.minion_id = vm.minion_id\n" +
                        " JOIN villains AS v ON v.villain_id = vm.villain_id\n" +
                        "WHERE vm.villain_id = %d;", villainId
        );
        StringBuilder stringBuilder = new StringBuilder();
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ) {

            int id = 1;
            boolean foundMinion = false;
            while (resultSet.next()) {
                if (id == 1) {
                    stringBuilder.append(String.format("Villain: %s%n", resultSet.getString("villain_name")));
                }
                String minionName = resultSet.getString("name");
                int minionAge = resultSet.getInt("age");
                if (minionName != null) {
                    foundMinion = true;
                    stringBuilder.append(String.format("%d. %s %d%n", id, minionName, minionAge));
                    id++;
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append(!foundMinion ? "<no minions>" : "");
            } else {
                stringBuilder.append(String.format("No villain with id %d found in the database", villainId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }
}
