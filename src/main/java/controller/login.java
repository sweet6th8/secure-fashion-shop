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
        // check if session is existed
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            resp.sendRedirect(getServletContext().getContextPath() + "/");
        }
        else {
            req.getRequestDispatcher(req.getContextPath()).forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String message = "Sai thông tin tài khoản mật khẩu ";
        UserDAO udao = new UserDAO();
        HttpSession session = req.getSession();
        try {
            User user = udao.getLogin(email, pass);
            if (user != null) {
                resp.sendRedirect(req.getContextPath());
                session.setAttribute("user", user);
            } else {
                req.setAttribute("message", message);
                req.getRequestDispatcher("/templates/login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
