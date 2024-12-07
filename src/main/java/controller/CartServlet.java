package controller;

import dao.CartDAO;
import dao.DBConnectionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;

import java.io.IOException;
import java.sql.Connection;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DBConnectionPool.getDataSource().getConnection()) {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");  // Giả định rằng userId đã được lưu trong session

            // Lấy giỏ hàng từ cơ sở dữ liệu
            CartDAO cartDAO = new CartDAO(connection);
            Cart cart = cartDAO.getCartByUserId(userId);

            // Đặt giỏ hàng vào request và chuyển hướng đến trang hiển thị giỏ hàng
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("templates/cart.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error connecting to the database", e);
        }

    }
}
