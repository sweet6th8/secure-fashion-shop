package controller;

import dao.CartDAO;
import dao.CartItemDAO;
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

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DBConnectionPool.getDataSource().getConnection()) {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));


            CartDAO cartDAO = new CartDAO(connection);
            CartItemDAO cartItemDAO = new CartItemDAO(connection);

            // Kiểm tra xem người dùng đã có giỏ hàng chưa, nếu chưa tạo mới
            Cart cart = cartDAO.getCartByUserId(userId);
            if (cart == null) {
                cartDAO.createCart(userId);
                cart = cartDAO.getCartByUserId(userId);
            }

            // Thêm sản phẩm vào giỏ hàng
            cartItemDAO.addCartItem(cart.getUserId(), productId, quantity);

            // Chuyển hướng người dùng về trang giỏ hàng
            response.sendRedirect("cart");
        } catch (Exception e) {
            throw new ServletException("Error connecting to the database", e);
        }
    }
}