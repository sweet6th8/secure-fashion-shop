package controller;

import dao.UserDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "DangNhap", urlPatterns = {"/templates/login"})
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String message = "Sai thông tin tài khoản mật khẩu ";
        ServletContext context = req.getServletContext();
        UserDAO udao = new UserDAO();
        HttpSession session = req.getSession();
        try {
            User user = udao.getLogin(email, pass);
            if (user != null) {
                context.setAttribute("message", message);
                session.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/templates/login.jsp");
            } else {
                resp.sendRedirect(req.getContextPath());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String message = "Sai thông tin tài khoản mật khẩu ";
        ServletContext context = req.getServletContext();
        UserDAO udao = new UserDAO();
        HttpSession session = req.getSession();
        try {
            User user = udao.getLogin(email, pass);
            if (user != null) {
                resp.sendRedirect(req.getContextPath());
                session.setAttribute("user", user);

            } else {
                context.setAttribute("message", message);

                resp.sendRedirect(req.getContextPath() + "/templates/login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
