package controller.web;

import dao.DBConnectionPool;
import dao.OrderItemDAO;
import dao.ProductDAO;
import dao.UserDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.HistoryProduct;
import model.Product;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/secure/history"})
public class history extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection con = DBConnectionPool.getDataSource().getConnection()) {
            int id = Integer.parseInt(req.getParameter("id"));
            OrderItemDAO orderItemDAO = new OrderItemDAO(con);
            List<HistoryProduct> list = orderItemDAO.getAllHistoryProducts(id);
            req.setAttribute("list", list);
            req.getRequestDispatcher("/templates/historyProduct.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
