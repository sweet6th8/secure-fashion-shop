package DB;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConnection {
    String url = "jdbc:sqlserver://ACER:1433;databaseName=Shop;encrypt=true;trustServerCertificate=true";
    String userName = "sa";
    String password = "nhutanh02042004";
    Connection connect ;

    public SQLServerConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
connect = DriverManager.getConnection(url, userName, password);
    }

    public void createStatement(String table , String query) throws SQLException {

        try {
            java.sql.Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("Kết nối thành công");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean checkEmailExist (String email) throws SQLException {
        String getEmail = "Select email from ThongTinDangNhap";
        java.sql.Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(getEmail);
        while (rs.next()) {
            if (email.equals(rs.getString(1))) {
                return false;
            }
        }
        return true;
    }
    public boolean checkLogin  (String email , String password ,String query ) {
        try {
            System.out.println("check");
            java.sql.Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if (email.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
SQLServerConnection connection = new SQLServerConnection();
connection.createStatement("ThongTinDangNhap","Select * from ThongTinDangNhap");

    }

}
