package dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    // Database connection details
    private static final String DB_USER = "nhutanh";
    private static final String DB_PASSWORD = "nhutanh02042004";
    private static final String DB_SERVER_NAME = "ACER";
    private static final int DB_PORT = 1433;
    private static final String DB_NAME = "ClothingShopWeb";

    // DataSource instance for SQL Server
    private static SQLServerDataSource dataSource = new SQLServerDataSource();

    // Static block to initialize the DataSource configuration
    static {
        dataSource.setUser(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setServerName(DB_SERVER_NAME);
        dataSource.setPortNumber(DB_PORT);
        dataSource.setDatabaseName(DB_NAME);


        dataSource.setTrustServerCertificate(true); // Skip certificate validation for development
    }

    // Static method to get a connection from the DataSource
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Optional main method to test the connection
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Connected to SQL Server successfully.");
            System.out.println("Database Metadata: " + conn.getMetaData().getDatabaseProductName()
                    + " Version: " + conn.getMetaData().getDatabaseProductVersion());
        } catch (SQLException e) {
            System.err.println("SQLException: Unable to connect to SQL Server.");
            e.printStackTrace();
        }
    }
}
