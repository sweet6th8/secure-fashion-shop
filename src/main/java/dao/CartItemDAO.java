package dao;

import model.CartItem;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CartItemDAO {

    private Connection connection;

    public CartItemDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy các mục trong giỏ hàng bằng cartId
    public Map<Integer, CartItem> getCartItemsByCartId(int cartId) {
        Map<Integer, CartItem> items = new HashMap<>();
        String query = "SELECT * FROM cart_item WHERE cart_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cartId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");

                // Lấy thông tin sản phẩm từ cơ sở dữ liệu
                ProductDAO productDao = new ProductDAO(connection);
                Product product = productDao.getProductById(productId);

                CartItem cartItem = new CartItem(product, quantity);
                items.put(productId, cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Thêm mục vào giỏ hàng
    public boolean addCartItem(int cartId, int productId, int quantity) {
        String query = "INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cartId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật số lượng của mục trong giỏ hàng
    public boolean updateCartItemQuantity(int cartItemId, int quantity) {
        String query = "UPDATE cart_item SET quantity = ? WHERE cart_item_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, cartItemId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa mục khỏi giỏ hàng
    public boolean deleteCartItem(int cartItemId) {
        String query = "DELETE FROM cart_item WHERE cart_item_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cartItemId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
