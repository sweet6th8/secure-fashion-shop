package controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet(name = "EditServlet", urlPatterns = {"/secure/EditServlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB threshold for in-memory storage
        maxFileSize = 1024 * 1024 * 10,      // 10MB maximum file size
        maxRequestSize = 1024 * 1024 * 50    // 50MB maximum request size
)

public class EditProfile  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role.equals("Admin")) {
            request.setAttribute("message","Vui lòng đăng nhập vào tài khoản User");
            request.getRequestDispatcher("/templates/login.jsp").forward(request, response);
        }
    }
}
