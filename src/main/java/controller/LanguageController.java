package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/language")
public class LanguageController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số ngôn ngữ từ request
        String lang = request.getParameter("lang");
        Locale locale;

if (lang == null) {
    locale = new Locale("en", "US");
}
else {
    // Đặt locale dựa trên tham số
    if ("vi".equals(lang)) {
        locale = new Locale("vi", "VN");
    } else {
        locale = new Locale("en", "US");
    }
}
        // Load các messages tương ứng
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        // Lưu các giá trị vào request attribute
        request.setAttribute("welcome", bundle.getString("welcome"));
        request.setAttribute("chooseLanguage", bundle.getString("chooseLanguage"));
        // Forward tới trang JSP
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}