package controller.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@WebServlet("/language")
public class LanguageController extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Lấy tham số ngôn ngữ từ request
//        String lang = request.getParameter("lang");
//        Locale locale;
//
//if (lang == null) {
//    locale = new Locale("en", "US");
//}
//else {
//    // Đặt locale dựa trên tham số
//    if ("vi".equals(lang)) {
//        locale = new Locale("vi", "VN");
//    } else {
//        locale = new Locale("en", "US");
//    }
//}
//        // Load các messages tương ứng
//        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
//
//        // Lưu các giá trị vào request attribute
//        request.setAttribute("welcome", bundle.getString("welcome"));
//        request.setAttribute("chooseLanguage", bundle.getString("chooseLanguage"));
//        // Forward tới trang JSP
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
//    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String lang = request.getParameter("lang");
    Locale locale;

    // Determine locale based on the "lang" parameter
    if (lang == null || lang.isEmpty()) {
        locale = new Locale("en", "US");
    } else {
        if ("vi".equals(lang)) {
            locale = new Locale("vi", "VN");
        } else {
            locale = new Locale("en", "US");
        }
    }

    System.out.println("Requested language: " + lang);
    System.out.println("Resolved locale: " + locale);
    System.out.println("Trying to load ResourceBundle for base name: messages, locale: " + locale);

    try {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        System.out.println("Successfully loaded ResourceBundle");
        request.setAttribute("welcome", bundle.getString("welcome"));
        request.setAttribute("chooseLanguage", bundle.getString("chooseLanguage"));
    } catch (MissingResourceException e) {
        System.err.println("Resource bundle not found: " + e.getMessage());
        e.printStackTrace();
        request.setAttribute("welcome", "Welcome!");
        request.setAttribute("chooseLanguage", "Choose your language:");
    }

    request.getRequestDispatcher("/index.jsp").forward(request, response);
}
}