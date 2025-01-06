package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String SQL_INSERT_USER = "INSERT INTO [dbo].[User] (username, password, email, fullName, address, phone, gender) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_LOGIN_USER = "SELECT * FROM [dbo].[User] WHERE email = ? AND password = ?";

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

    public List<User> getAllUsers() throws SQLException {
        String SQL_GET_ALL_USERS = "SELECT * FROM [dbo].[User]";
        List<User> users = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(SQL_GET_ALL_USERS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                users.add(createUserFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving all users", e);
        }

        return users;
    }

    public User getUserById(int userId) throws SQLException {
        String SQL_GET_USER_BY_ID = "SELECT * FROM [dbo].[User] WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(SQL_GET_USER_BY_ID)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return createUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving user by ID", e);
        }
        return null;
    }


    public boolean updateUser(User user) throws SQLException {
        String SQL_UPDATE_USER = "UPDATE [dbo].[User] SET username = ?, password = ?, email = ?, fullName = ?, address = ?, phone = ?, gender = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_USER)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhone());
            ps.setInt(7, user.isGender() ? 1 : 0);
            ps.setInt(8, user.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new SQLException("Error updating user", e);
        }
    }


    public boolean deleteUser(int userId) throws SQLException {
        String SQL_DELETE_USER = "DELETE FROM User WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(SQL_DELETE_USER)) {
            ps.setInt(1, userId);

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new SQLException("Error deleting user", e);
        }
    }
    
}