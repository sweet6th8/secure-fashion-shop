package dao;

import model.Product;
import dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Thêm sản phẩm
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (name, price, brand, size, color, gender, description, imageUrl) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getBrand());
            statement.setString(4, product.getSize());
            statement.setString(5, product.getColor());
            statement.setString(6, product.getGender());
            statement.setString(7, product.getDescription());
            statement.setString(8, product.getImageUrl());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy sản phẩm theo ID
    public Product getProductById(int id) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setBrand(resultSet.getString("brand"));
                product.setSize(resultSet.getString("size"));
                product.setColor(resultSet.getString("color"));
                product.setGender(resultSet.getString("gender"));
                product.setDescription(resultSet.getString("description"));
                product.setImageUrl(resultSet.getString("imageUrl"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setBrand(resultSet.getString("brand"));
                product.setSize(resultSet.getString("size"));
                product.setColor(resultSet.getString("color"));
                product.setGender(resultSet.getString("gender"));
                product.setDescription(resultSet.getString("description"));
                product.setImageUrl(resultSet.getString("imageUrl"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Cập nhật thông tin sản phẩm
    public void updateProduct(Product product) {
        String sql = "UPDATE products SET name = ?, price = ?, brand = ?, size = ?, color = ?, gender = ?, description = ?, imageUrl = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getBrand());
            statement.setString(4, product.getSize());
            statement.setString(5, product.getColor());
            statement.setString(6, product.getGender());
            statement.setString(7, product.getDescription());
            statement.setString(8, product.getImageUrl());
            statement.setInt(9, product.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
