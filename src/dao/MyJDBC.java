package dao;

import java.sql.*;
public class MyJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
            "root",
                    "nghoaian1612."
);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}