package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int userId; // ID người dùng
    private List<CartItem> items; // Danh sách các mục trong giỏ hàng

    public Cart() {
        this.items = new ArrayList<>();
    }
    public Cart(int userId) {
        this.userId = userId;
        this.items = new ArrayList<>();
    }
    public void addItem(CartItem item) {
        items.add(item);
    }
    public void removeItem(CartItem item) {
        items.remove(item);
    }
    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
