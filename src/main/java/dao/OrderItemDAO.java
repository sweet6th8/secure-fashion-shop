package dao;

import model.HistoryProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAO {
private Connection conn;
public OrderItemDAO(Connection conn) {
    this.conn = conn;
}
public List<HistoryProduct> getAllHistoryProducts(int userId) throws SQLException {

    List<HistoryProduct> historyProducts = new ArrayList<HistoryProduct>();
    String query = "SELECT P.id , P.name , OI.price, OI.quantity , P.photo,O.status  FROM " +
            "Order_Items OI JOIN    Orders O on O.id = OI.order_id" +
            " JOIN product P ON P.id = OI.product_id" +
            " WHERE O.user_id =  ?";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, userId);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        HistoryProduct hp = new HistoryProduct(
                rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6)

        );
        historyProducts.add(hp);

    }

    return historyProducts;
}
    // Thêm sản phẩm vào đơn hàng
//    public void addOrderItem(OrderItem orderItem) {
//        String sql = "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, orderItem.getOrderId());
//            statement.setInt(2, orderItem.getProductId());
//            statement.setInt(3, orderItem.getQuantity());
//            statement.setDouble(4, orderItem.getPrice());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Lấy danh sách sản phẩm trong đơn hàng
//    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
//        List<OrderItem> orderItems = new ArrayList<>();
//        String sql = "SELECT * FROM order_items WHERE order_id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, orderId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                OrderItem orderItem = new OrderItem();
//                orderItem.setId(resultSet.getInt("id"));
//                orderItem.setOrderId(resultSet.getInt("order_id"));
//                orderItem.setProductId(resultSet.getInt("product_id"));
//                orderItem.setQuantity(resultSet.getInt("quantity"));
//                orderItem.setPrice(resultSet.getDouble("price"));
//                orderItems.add(orderItem);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return orderItems;
//    }
//
//    // Cập nhật thông tin sản phẩm trong đơn hàng
//    public void updateOrderItem(OrderItem orderItem) {
//        String sql = "UPDATE order_items SET product_id = ?, quantity = ?, price = ? WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setInt(1, orderItem.getProductId());
//            statement.setInt(2, orderItem.getQuantity());
//            statement.setDouble(3, orderItem.getPrice());
//            statement.setInt(4, orderItem.getId());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Xóa sản phẩm khỏi đơn hàng
//    public void deleteOrderItem(int id) {
//        String sql = "DELETE FROM order_items WHERE id = ?";
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
