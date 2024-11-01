package dao;

public class CartItemDAO {

    // Thêm một mục vào giỏ hàng
//    public void addCartItem(CartItem item, int cartId) {
//        String sql = "INSERT INTO cart_items (cart_id, product_id, product_name, price, quantity) VALUES (?, ?, ?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, cartId); // ID của giỏ hàng
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
//    // Lấy tất cả các mục trong giỏ hàng theo cartId
//    public List<CartItem> getCartItemsByCartId(int cartId) {
//        List<CartItem> items = new ArrayList<>();
//        String sql = "SELECT * FROM cart_items WHERE cart_id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, cartId);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                CartItem item = new CartItem(
//                        resultSet.getInt("product_id"),
//                        resultSet.getString("product_name"),
//                        resultSet.getDouble("price"),
//                        resultSet.getInt("quantity")
//                );
//                items.add(item);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return items;
//    }
//
//    // Cập nhật số lượng của một mục trong giỏ hàng
//    public void updateCartItemQuantity(int cartId, int productId, int quantity) {
//        String sql = "UPDATE cart_items SET quantity = ? WHERE cart_id = ? AND product_id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, quantity);
//            statement.setInt(2, cartId);
//            statement.setInt(3, productId);
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Xóa một mục khỏi giỏ hàng
//    public void deleteCartItem(int cartId, int productId) {
//        String sql = "DELETE FROM cart_items WHERE cart_id = ? AND product_id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, cartId);
//            statement.setInt(2, productId);
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
