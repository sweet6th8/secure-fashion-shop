// CategoriesDAO.java
package dao;

import model.Categories;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public List<Categories> getAllCategories() {
        List<Categories> categoriesList = new ArrayList<>();
        String query = "SELECT * FROM categories";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                Categories category = new Categories();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categoriesList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoriesList;
    }

    // Thêm các phương thức khác như addCategory(), updateCategory(), deleteCategory() nếu cần
}
