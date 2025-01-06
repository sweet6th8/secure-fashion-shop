package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name="Admin" , urlPatterns = {"/secure/admin"})
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     HttpSession session = req.getSession();
     String role = (String) session.getAttribute("role");
     if (role.equals("Admin")) {
         req.setAttribute("Message", "Chào mừng đến với admin ");
         req.getRequestDispatcher("/templates/admin/admin_home.jsp").forward(req, resp);
     }
     else {
         req.setAttribute("Message", "Vui lòng đăng nhập bằng tài khoan admin !");
         req.getRequestDispatcher("/templates/login").forward(req, resp);
     }
    }
}