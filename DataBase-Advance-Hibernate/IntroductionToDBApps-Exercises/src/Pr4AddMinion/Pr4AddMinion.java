package Pr4AddMinion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Pr4AddMinion {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] minionData = reader.readLine().split("\\s+");
        String[] villainData = reader.readLine().split("\\s+");

        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String minionTown = minionData[3];
        String villainName = villainData[1];
        StringBuilder stringBuilder = new StringBuilder();

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ) {
            String select = "SELECT * FROM towns WHERE name = '%s'";
            String insert = "INSERT INTO towns(name) VALUES('%s')";
            String output = String.format("Town %s was added to the database\n", minionTown);
            String query = String.format(select, minionTown);
            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
                String insertTown = String.format(insert, minionTown);
                statement.execute(insertTown);
                stringBuilder.append(output);
            }

            select = "SELECT * FROM villains WHERE villain_name = '%s'";
            insert = "INSERT INTO villains(villain_name,evillness_factor) VALUES('%s','Evil')";
            output = String.format("Villain %s was added to the database\n", villainName);
            query = String.format(select, villainName);
            resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
                String insertVillain = String.format(insert, villainName);
                statement.execute(insertVillain);
                stringBuilder.append(output);
            }

            query = String.format("SELECT town_id FROM towns WHERE name = '%s'", minionTown);
            resultSet = statement.executeQuery(query);

            int town_id = resultSet.next() ? resultSet.getInt("town_id") : 0;
            query = String.format("INSERT INTO minions(name,age,town_id) VALUES('%s',%d,%d)", minionName,minionAge,town_id);
            statement.execute(query);

            query = String.format("SELECT minion_id FROM minions WHERE name = '%s'", minionName);
            resultSet = statement.executeQuery(query);
            int minionId = resultSet.next() ? resultSet.getInt("minion_id") : 0;

            query = String.format("SELECT villain_id FROM villains WHERE villain_name = '%s'", villainName);
            resultSet = statement.executeQuery(query);
            int villainId = resultSet.next() ? resultSet.getInt("villain_id") : 0;

            if (minionId != 0 && villainId != 0) {
                query = String.format("INSERT INTO villains_minions(villain_id,minion_id) VALUES (%d,%d)", villainId, minionId);
                statement.execute(query);
                stringBuilder.append(String.format("Successfully added %s to be minion of %s\n", minionName, villainName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }
}
