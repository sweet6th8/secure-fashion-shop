package dao;

public class UserDAO {

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
