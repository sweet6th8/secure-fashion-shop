package controller;

import dao.DBConnectionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DBConnectionPool.getDataSource().getConnection()) { // Lấy connection từ pool

            List<Category> categories = new ArrayList<>();
            categories.add(new Category(1, "Electronics", "/store/electronics"));
            categories.add(new Category(2, "Clothing", "/store/clothing"));
            request.setAttribute("links", categories);


            // Tạo danh sách Product
            List<Product> products = new ArrayList<>();

            request.setAttribute("products", products);

            // Truyền số lượng sản phẩm
            request.setAttribute("product_count", products.size());

            // Chuyển tới trang JSP
            request.getRequestDispatcher("/templates/store/store.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error connecting to the database", e);
        }

    }
}
