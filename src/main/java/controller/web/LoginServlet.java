package controller.web;

import Util.GeneratePassword;
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


@WebServlet(name = "Login", urlPatterns = {"/templates/Login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // check if session is existed
        try {
            String success = req.getParameter("success");
            req.setAttribute("success", success);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
            HttpSession session = req.getSession();
            try {
                if (!udao.checkActive(email)) {
                    String message = "Account is not active!";
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/templates/login.jsp").forward(req,resp);
                }
                if (!udao.checkEmailExist(email)) {
                    String message = "Email is not exist!";
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/templates/login.jsp").forward(req,resp);

                }
                String realPass = udao.getPassword(email);
             if (!GeneratePassword.checkPassword(pass, realPass)) {
                 String message = "Incorrect account password information";
                 req.setAttribute("message", message);
                 req.getRequestDispatcher("/templates/login.jsp").forward(req,resp);

             }
                User user = udao.getLogin(email,realPass);
                if (user == null) {
                    String message = "Incorrect email or password";
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/templates/login.jsp").forward(req,resp);

                } else {
                    int userId = user.getId();
                    String role = user.getRole();
                    session.setAttribute("role", role);
                    session.setAttribute("userId", userId);
                    session.setAttribute("Img" , user.getImage());


                    if (role.equals("Admin")) {
                        resp.sendRedirect(getServletContext().getContextPath() + "/secure/admin");
                    }
                    else {
                        CartDAO cdao = new CartDAO(connection);
                        Cart cart = cdao.getCartByUserId(userId);
                        session.setAttribute("count", cart != null ? cart.getItems().size() : 0);

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
