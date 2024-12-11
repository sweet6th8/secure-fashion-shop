package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int userId;  // ID của người dùng sở hữu giỏ hàng này
    private Map<Integer, CartItem> items;  // Sử dụng Map với productId làm key và CartItem làm value

    public Cart(int userId) {
        this.userId = userId;
        this.items = new HashMap<>();
    }

    // Thêm sản phẩm vào giỏ hàng hoặc tăng số lượng nếu đã tồn tại
    public void addItem(Product product, int quantity) {
        if (items.containsKey(product.getId())) {
            CartItem existingItem = items.get(product.getId());
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            items.put(product.getId(), new CartItem(product, quantity));
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public void removeItem(int productId) {
        items.remove(productId);
    }

    // Cập nhật số lượng của một sản phẩm
    public void updateQuantity(int productId, int quantity) {
        if (items.containsKey(productId)) {
            CartItem item = items.get(productId);
            item.setQuantity(quantity);
        }
    }

    // Tính tổng giá trị của giỏ hàng sau khi áp dụng giảm giá
    public double calculateTotal() {
        return items.values().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    // Lấy toàn bộ các mục trong giỏ hàng
    public Map<Integer, CartItem> getItems() {
        return items;
    }

    // Thiết lập các mục trong giỏ hàng từ một Map
    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    // Getter và Setter cho userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
