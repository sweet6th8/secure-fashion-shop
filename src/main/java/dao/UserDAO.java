package dao;


import model.User;

import java.sql.*;

public class UserDAO {
    public UserDAO() {
    }

    public boolean registerUsser(User user) throws SQLException {
        int gender = (user.isGender()) ? 1 : 0;

        String sql = "insert into ListUser  (username, password, email, fullName, address, phone,gender) " +
                "VALUES ('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getEmail() + "','" +
                user.getFullName() + "','" + user.getAddress() + "','" + user.getPhone() + "'," + gender + ")";
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
            System.out.println("thêm user vào db thành công !");
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public User getLogin(String email, String password) throws SQLException {
        String sql = "Select   * from ListUser where email ='" + email + "'";
        User user = new User();
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String userEmail = rs.getString(4);
            String userPassword = rs.getString(3);
            if (!userEmail.equals(email) || !userPassword.equals(password)) {
                System.out.println("user is not exist");
                return null;
            }
            user.setUsername(rs.getString(2));
            user.setEmail(userEmail);
            user.setPassword(userPassword);
            user.setFullName(rs.getString(5));
            user.setAddress(rs.getString(6));
            user.setPhone(rs.getString(7));
            user.setGender(rs.getBoolean(8));

        }
        System.out.println(user.isGender());

        return user;
    }
// Thêm người dùng
//    public void addUser(User user) {
//        String sql = "INSERT INTO users (username, password, email, full_name, address, phone) VALUES (?, ?, ?, ?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setString(1, user.getUsername());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getEmail());
//            statement.setString(4, user.getFullName());
//            statement.setString(5, user.getAddress());
//            statement.setString(6, user.getPhone());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Lấy người dùng theo ID
//    public User getUserById(int id) {
//        User user = null;
//        String sql = "SELECT * FROM users WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setUsername(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                user.setEmail(resultSet.getString("email"));
//                user.setFullName(resultSet.getString("full_name"));
//                user.setAddress(resultSet.getString("address"));
//                user.setPhone(resultSet.getString("phone"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
//
//    // Lấy tất cả người dùng
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql);
//             ResultSet resultSet = statement.executeQuery()) {
//
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setUsername(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                user.setEmail(resultSet.getString("email"));
//                user.setFullName(resultSet.getString("full_name"));
//                user.setAddress(resultSet.getString("address"));
//                user.setPhone(resultSet.getString("phone"));
//                users.add(user);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    // Cập nhật thông tin người dùng
//    public void updateUser(User user) {
//        String sql = "UPDATE users SET username = ?, password = ?, email = ?, full_name = ?, address = ?, phone = ? WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setString(1, user.getUsername());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getEmail());
//            statement.setString(4, user.getFullName());
//            statement.setString(5, user.getAddress());
//            statement.setString(6, user.getPhone());
//            statement.setInt(7, user.getId());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Xóa người dùng
//    public void deleteUser(int id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, id);
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
