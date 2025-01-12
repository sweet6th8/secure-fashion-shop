package controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet(urlPatterns = {"/secure/logout"})
public class LogOut  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        session.removeAttribute("user");
        session.invalidate();
        if (user != null) {

            resp.sendRedirect(req.getContextPath() + "/");
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/templates/login.jsp");
        }

    }
}
