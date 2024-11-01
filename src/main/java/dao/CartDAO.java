package dao;

import model.Cart;
import model.CartItem;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    // Lưu giỏ hàng vào cơ sở dữ liệu
//    public void saveCart(Cart cart) {
//        String sql = "INSERT INTO carts (user_id) VALUES (?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, cart.getUserId());
//            statement.executeUpdate();
//
//            // Lưu các mục trong giỏ hàng
//            for (CartItem item : cart.getItems()) {
//                saveCartItem(cart.getUserId(), item);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Lưu mục giỏ hàng
//    private void saveCartItem(int userId, CartItem item) {
//        String sql = "INSERT INTO cart_items (cart_id, product_id, product_name, price, quantity) VALUES (?, ?, ?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, userId);
//            statement.setInt(2, item.getProductId());
//            statement.setString(3, item.getProductName());
//            statement.setDouble(4, item.getPrice());
//            statement.setInt(5, item.getQuantity());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Lấy giỏ hàng theo ID người dùng
//    public Cart getCartByUserId(int userId) {
//        Cart cart = new Cart(userId);
//        String sql = "SELECT * FROM cart_items WHERE cart_id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, userId);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                CartItem item = new CartItem(
//                        resultSet.getInt("product_id"),
//                        resultSet.getString("product_name"),
//                        resultSet.getDouble("price"),
//                        resultSet.getInt("quantity")
//                );
//                cart.addItem(item);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return cart;
//    }
}
