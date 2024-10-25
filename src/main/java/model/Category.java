package model;

public class Category {
    private int id;
    private String categoryName;
    private String url;

    // Constructors
    public Category(int id, String categoryName, String url) {
        this.id = id;
        this.categoryName = categoryName;
        this.url = url;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
