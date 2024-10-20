package model;

public class Product {
    private int id; // ID sản phẩm
    private String name; // Tên sản phẩm
    private double price; // Giá sản phẩm
    private String brand; // Thương hiệu
    private String size; // Kích thước
    private String color; // Màu sắc
    private String gender; // Giới tính (nam, nữ, unisex)
    private String description; // Mô tả sản phẩm
    private String imageUrl; // URL hình ảnh sản phẩm

    // Constructor
    public Product() {}

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
