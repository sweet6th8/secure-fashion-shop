package controller.web;

import Service.SendMail;
import Util.CreateUser;
import dao.CartDAO;
import dao.DBConnectionPool;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.User;

import javax.mail.Transport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/templates/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    public static final String ERROR_MESSAGE = "REGISTER ERROR";
    public static final String SUCCESS = "REGISTER SUCCESS";
    public static final String EMAIL_EXISTS = "EMAIL EXISTS";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = DBConnectionPool.getDataSource().getConnection()) { // Lấy connection từ pool

            // call user dao
            UserDAO userDAO = new UserDAO(connection);
            CartDAO cartDAO = new CartDAO(connection);
            User user = CreateUser.createUser(req, resp);

            if (user == null ) {
                req.setAttribute("message", ERROR_MESSAGE);
                req.getRequestDispatcher("/templates/LoginServlet.jsp").forward(req, resp);
                return;
            }if (userDAO.checkEmailExist(user.getEmail())) {
                req.setAttribute("message", EMAIL_EXISTS);
                req.getRequestDispatcher("/templates/RegisterServlet.jsp").forward(req, resp);
            }
            try {
                if (userDAO.registerUser(user)) {
                    int id = userDAO.getUserId(user.getEmail());
                    cartDAO.createCart(new Cart(id));
                    req.setAttribute("message", SUCCESS);
                    SendMail service = new SendMail();
                    Transport.send(service.activeAcount(user.getEmail(),id));

                    resp.sendRedirect(req.getContextPath() + "/templates/LoginServlet.jsp");
                    return;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/templates/RegisterServlet.jsp");

        } catch (Exception e) {
            throw new ServletException("Error connecting to the database", e);
        }

    }
}
