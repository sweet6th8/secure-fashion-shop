package dao;
import model.User;
import java.sql.*;
public class UserDAO {

    private static final String SQL_INSERT_USER = "INSERT INTO ListUser (username, password, email, fullName, address, phone, gender) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_LOGIN_USER = "SELECT * FROM ListUser WHERE email = ? AND password = ?";

    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean registerUser(User user) throws SQLException {
        int gender = user.isGender() ? 1 : 0;

        try (PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhone());
            ps.setInt(7, gender);
            ps.executeUpdate();
            System.out.println("Successfully added user to the database!");
            return true;
        } catch (SQLException e) {
            throw new SQLException("Error registering user", e);
        }
    }

    public User getLogin(String email, String password) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(SQL_LOGIN_USER)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return createUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving user by login", e);
        }
        return null;
    }

    private User createUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setFullName(rs.getString("fullName"));
        user.setAddress(rs.getString("address"));
        user.setPhone(rs.getString("phone"));
        user.setGender(rs.getBoolean("gender"));
        return user;
    }
}