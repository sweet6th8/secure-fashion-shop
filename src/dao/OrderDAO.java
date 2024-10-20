package dao;

import model.Order;
import dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    // Thêm đơn hàng
    public void addOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, total_amount, payment_method, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getUserId());
            statement.setDouble(2, order.getTotalAmount());
            statement.setString(3, order.getPaymentMethod());
            statement.setString(4, order.getStatus());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy đơn hàng theo ID
    public Order getOrderById(int id) {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setTotalAmount(resultSet.getDouble("total_amount"));
              //  order.setPaymentMethod(resultSet.getString("payment_method"));
                order.setStatus(resultSet.getString("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    // Lấy tất cả đơn hàng
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setTotalAmount(resultSet.getDouble("total_amount"));
               // order.setPaymentMethod(resultSet.getString("payment_method"));
                order.setStatus(resultSet.getString("status"));
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Cập nhật thông tin đơn hàng
    public void updateOrder(Order order) {
        String sql = "UPDATE orders SET user_id = ?, total_amount = ?, payment_method = ?, status = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getUserId());
            statement.setDouble(2, order.getTotalAmount());
            statement.setString(3, order.getPaymentMethod());
            statement.setString(4, order.getStatus());
            statement.setInt(5, order.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa đơn hàng
    public void deleteOrder(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
