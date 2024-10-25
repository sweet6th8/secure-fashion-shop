package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tạo danh sách Category

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Electronics", "/store/electronics"));
        categories.add(new Category(2, "Clothing", "/store/clothing"));
        request.setAttribute("links", categories);


        // Tạo danh sách Product
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 1200.00, "/static/images/laptop.jpg"));
        products.add(new Product(2, "Shirt", 35.99, "/static/images/shirt.jpg"));
        request.setAttribute("products", products);

        // Truyền số lượng sản phẩm
        request.setAttribute("product_count", products.size());

        // Chuyển tới trang JSP
        request.getRequestDispatcher("/templates/store/store.jsp").forward(request, response);
    }
}
