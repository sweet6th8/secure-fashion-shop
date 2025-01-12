package controller.web;

import Util.CreateUser;
import Util.validation;
import dao.DBConnectionPool;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/templates/register"})
public class register extends HttpServlet {
    public static final String ERROR_MESSAGE = "REGISTER ERROR";
    public static final String SUCCESS = "REGISTER SUCCESS";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = DBConnectionPool.getDataSource().getConnection()) { // Lấy connection từ pool
            User user = CreateUser.createUser(req, resp);
            if (user == null) {
                req.setAttribute("message", ERROR_MESSAGE);
                req.getRequestDispatcher("/templates/login.jsp").forward(req, resp);
                return;
            }
            // call user dao
            UserDAO userDAO = new UserDAO(connection);
            try {
                if (userDAO.registerUser(user)) {
                    req.setAttribute("message", SUCCESS);
                    resp.sendRedirect(req.getContextPath() + "/templates/login.jsp");
                    return;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/templates/register.jsp");

        } catch (Exception e) {
            throw new ServletException("Error connecting to the database", e);
        }

    }
}
