package dao;

import model.Payment;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    // Thêm thông tin thanh toán
//    public void addPayment(Payment payment) {
//        String sql = "INSERT INTO payments (order_id, amount, method, status) VALUES (?, ?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, payment.getOrderId());
//            statement.setDouble(2, payment.getAmount());
//            statement.setString(3, payment.getPaymentMethod());
//            statement.setString(4, payment.getStatus());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Lấy thông tin thanh toán theo ID
//    public Payment getPaymentById(int id) {
//        Payment payment = null;
//        String sql = "SELECT * FROM payments WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                payment = new Payment();
//                payment.setId(resultSet.getInt("id"));
//                payment.setOrderId(resultSet.getInt("order_id"));
//                payment.setAmount(resultSet.getDouble("amount"));
//                payment.setPaymentMethod(resultSet.getString("method"));
//                payment.setStatus(resultSet.getString("status"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return payment;
//    }
//
//    // Lấy tất cả thông tin thanh toán
//    public List<Payment> getAllPayments() {
//        List<Payment> payments = new ArrayList<>();
//        String sql = "SELECT * FROM payments";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql);
//             ResultSet resultSet = statement.executeQuery()) {
//
//            while (resultSet.next()) {
//                Payment payment = new Payment();
//                payment.setId(resultSet.getInt("id"));
//                payment.setOrderId(resultSet.getInt("order_id"));
//                payment.setAmount(resultSet.getDouble("amount"));
//                payment.setPaymentMethod(resultSet.getString("method"));
//                payment.setStatus(resultSet.getString("status"));
//                payments.add(payment);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return payments;
//    }
//
//    // Cập nhật thông tin thanh toán
//    public void updatePayment(Payment payment) {
//        String sql = "UPDATE payments SET order_id = ?, amount = ?, method = ?, status = ? WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, payment.getOrderId());
//            statement.setDouble(2, payment.getAmount());
//            statement.setString(3, payment.getPaymentMethod());
//            statement.setString(4, payment.getStatus());
//            statement.setInt(5, payment.getId());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Xóa thông tin thanh toán
//    public void deletePayment(int id) {
//        String sql = "DELETE FROM payments WHERE id = ?";
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
