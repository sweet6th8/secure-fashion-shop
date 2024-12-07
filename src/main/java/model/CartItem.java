package model;
public class CartItem {
    private Product product;  // Đối tượng Product chứa thông tin chi tiết của sản phẩm
    private int quantity;      // Số lượng sản phẩm trong giỏ hàng

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Tính giá sau khi áp dụng giảm giá
    public double getDiscountedPrice() {
        double discountAmount = product.getPrice() * (product.getDiscount() / 100.0);
        return product.getPrice() - discountAmount;
    }

    // Tính tổng giá cho mục này (giá sau giảm * số lượng)
    public double getTotalPrice() {
        return getDiscountedPrice() * quantity;
    }
}

