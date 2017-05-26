package Pr7PrintAllMinionNames;


import java.sql.*;
import java.util.LinkedList;

public class PrintAllMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedList<String> resultList = new LinkedList<>();
        try(
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ) {

            String query = "SELECT COUNT(*) AS c FROM minions";
            ResultSet resultSet = statement.executeQuery(query);
            int size = resultSet.next() ? resultSet.getInt("c") : 0;
            query = "SELECT name FROM minions";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                linkedList.add(resultSet.getString("name"));
            }
            while (!linkedList.isEmpty()) {
                String first = linkedList.poll();
                String last = linkedList.pollLast();
                resultList.add(first);
                resultList.add(last);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultList.peekLast() == null) {
            resultList.pollLast();
        }
        resultList.forEach(System.out::println);
    }
}
