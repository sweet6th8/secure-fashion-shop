package model;

public class CartItem {
    private int productId; // ID sản phẩm
    private String productName; // Tên sản phẩm
    private double price; // Giá sản phẩm
    private int quantity; // Số lượng sản phẩm

    public CartItem(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Tính tổng giá cho mục
    public double getTotalPrice() {
        return price * quantity;
    }

    // Getter và Setter
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
