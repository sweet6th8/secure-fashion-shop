package dao;

import model.User;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean registerUsser(User user) throws SQLException {
        int gender = (user.isGender()) ? 1 : 0;
        String sql = "insert into ListUser  (username, password, email, fullName, address, phone,gender) " +
                "VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhone());
            ps.setInt(7, gender);
            ps.executeUpdate();
            System.out.println("thêm user vào db thành công !");
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return true;
    }

    public User getLogin(String email, String password) throws SQLException {
        User user = new User();
        String sql = "select * from ListUser where email = ? and password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("fullName"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setGender(rs.getBoolean("gender"));
                return user;
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return null;
    }
}