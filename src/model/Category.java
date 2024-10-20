package model;

import java.util.List;

public class Category {
    private int id; // ID danh mục
    private String name; // Tên danh mục
    private String description; // Mô tả danh mục
    private List<Product> products; // Danh sách sản phẩm trong danh mục

    // Constructor
    public Category() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
