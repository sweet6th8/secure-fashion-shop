package controller;

import dao.UserDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "DangNhap", urlPatterns = {"/templates/login"})
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        UserDAO udao = new UserDAO();
        try {
            if (!udao.getLogin(email, pass)) {
                resp.sendRedirect(req.getContextPath() + "/templates/register.jsp");
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String message = "Sai thông tin tài khoản mật khẩu ";
        ServletContext context = req.getServletContext();
        UserDAO udao = new UserDAO();
        try {
            if (!udao.getLogin(email, pass)) {
                context.setAttribute("message", message);
                resp.sendRedirect(req.getContextPath() + "/templates/login.jsp");
            } else {
                resp.sendRedirect(req.getContextPath());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
