package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = {"/home", "/index"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Bạn có thể thêm dữ liệu vào request ở đây nếu cần
        // Ví dụ: request.setAttribute("products", listProducts);

        // Điều hướng đến trang home.jsp
        request.getRequestDispatcher("/templates/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý các yêu cầu POST (nếu có)
        doGet(request, response); // Với nhiều trường hợp, bạn có thể xử lý POST giống như GET
    }
}
