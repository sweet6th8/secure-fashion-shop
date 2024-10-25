package model;
public class Product {
    private int id;
    private String productName;
    private double price;
    private String imageUrl;

    // Constructors
    public Product(int id, String productName, double price, String imageUrl) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
