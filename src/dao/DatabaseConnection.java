package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name"; // Thay đổi tên cơ sở dữ liệu của bạn
    private static final String USER = "your_username"; // Tên người dùng MySQL
    private static final String PASSWORD = "your_password"; // Mật khẩu MySQL

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Tải driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Tạo kết nối
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
