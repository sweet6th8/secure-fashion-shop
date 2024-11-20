package controller;

import dao.ProductDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CartItem;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String size = req.getParameter("size");
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(Integer.parseInt(id));
        ServletContext context = getServletContext();
        List<CartItem> cart = (List<CartItem>) context.getAttribute("cartItems");
        if (cart == null && product != null) {
            cart = new ArrayList<>();


        }
        PrintWriter writer = resp.getWriter();
        writer.println("cart = " + cart);




    }
}
