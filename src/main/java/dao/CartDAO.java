package dao;

import model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDAO {
    private Connection connection;

    public CartDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy giỏ hàng của người dùng bằng userId
    public Cart getCartByUserId(int userId) {
        Cart cart = new Cart(userId);
        String query = "SELECT * FROM cart WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int cartId = rs.getInt("cart_id");
                cart.setItems(new CartItemDAO(connection).getCartItemsByCartId(cartId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    // Tạo giỏ hàng mới cho người dùng
    public boolean createCart(int userId) {
        String query = "INSERT INTO cart (user_id) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
