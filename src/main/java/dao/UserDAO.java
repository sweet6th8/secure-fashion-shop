package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String SQL_INSERT_USER = "INSERT INTO [dbo].[User] (username, password, email, fullName, address, phone, gender,role,Img) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_LOGIN_USER = "SELECT * FROM [dbo].[User] WHERE email = ? AND password = ?";
    private static final String SQL_UPDATE_PASSWORD = "UPDATE [dbo].[User] SET password = ? WHERE email = ?";
    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean updatePassword(String email, String password) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_PASSWORD);
        ps.setString(1, password);
        ps.setString(2, email);
        int result = ps.executeUpdate();
        return result == 1;
    }

    public boolean registerUser(User user) throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER)) {
            CreatePreparedStatement(user, ps);
            int gender = user.isGender() ? 1 : 0;
            String role = "User";
            String Img = "/static/images/avatars/user.png";
            ps.setInt(7, gender);
            ps.setString(8, role);
            ps.setString(9, Img);
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

    private void CreatePreparedStatement(User user, PreparedStatement ps) throws SQLException {

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getFullName());
        ps.setString(5, user.getAddress());
        ps.setString(6, user.getPhone());

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
        user.setRole(rs.getString("role"));
        user.setImage(rs.getString("Img"));
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
        String SQL_UPDATE_USER = "UPDATE [dbo].[User] SET  email = ?, fullName = ?, address = ?, phone = ? , img = ?  WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_USER)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getImage());
            ps.setInt(6, user.getId());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new SQLException("Error updating user", e);
        }
    }


    public boolean deleteUser(int userId) throws SQLException {
        String SQL_DELETE_USER = "DELETE FROM [dbo].[User] WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(SQL_DELETE_USER)) {
            ps.setInt(1, userId);

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new SQLException("Error deleting user", e);
        }
    }

    public boolean checkEmailExist(String email) throws SQLException {
        String query = "SELECT email FROM [dbo].[User] WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, email);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {

                return true;

            }
        }
        return false;
    }
}