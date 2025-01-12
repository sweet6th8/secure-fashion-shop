package controller.web;

import dao.DBConnectionPool;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/secure/saved"})
public class saved  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try (Connection con = DBConnectionPool.getDataSource().getConnection()) {
           int id = Integer.parseInt(req.getParameter("id"));
           UserDAO dao = new UserDAO(con);
           User user = dao.getUserById(id);
           req.setAttribute("user", user);

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
}
