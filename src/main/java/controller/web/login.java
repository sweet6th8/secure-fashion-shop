package controller.web;

import dao.CartDAO;
import dao.DBConnectionPool;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet(name = "Login", urlPatterns = {"/templates/login"})
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
        try (Connection connection = DBConnectionPool.getDataSource().getConnection()) { // Lấy connection từ pool

            String email = req.getParameter("email");
            String pass = req.getParameter("password");
            UserDAO udao = new UserDAO(connection);
            CartDAO cdao = new CartDAO(connection);
            HttpSession session = req.getSession();
            try {
                User user = udao.getLogin(email, pass);

                if (user == null) {
                    String message = "Sai thông tin tài khoản mật khẩu ";
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/templates/login.jsp").forward(req,resp);

                } else {
                    int userId = user.getId();
                    String role = user.getRole();
                  Cart cart=  cdao.getCartByUserId(userId);
                    session.setAttribute("count", cart.getItems().size());
                    session.setAttribute("role", role);
                    session.setAttribute("userId", userId);
                    session.setAttribute("Img" , user.getImage());

                    if (role.equals("Admin")) {
                        resp.sendRedirect(getServletContext().getContextPath() + "/secure/admin");
                    }
                    else {
                        resp.sendRedirect(req.getContextPath());
                    }
                    // fix here, tam thoi dung sendRedirect nen luu user trong session
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new ServletException("Error connecting to the database", e);
        }


    }
}
