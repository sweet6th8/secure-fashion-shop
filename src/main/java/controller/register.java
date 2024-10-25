package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet (urlPatterns = {"/templates/register"})
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String FirstName = req.getParameter("FirstName");
            String LastName = req.getParameter("LastName");
        String Email = req.getParameter("Email");
        boolean gender = (req.getParameter("gender").equalsIgnoreCase("1")) ? true : false;
        String password = req.getParameter("password");
        String checkPassword = req.getParameter("CheckPassword");
        String city = req.getParameter("city");

        User user = new User();
        user.setFullName(FirstName.concat(" " +LastName));
        user.setGender(gender);
        user.setEmail(Email);
        user.setId(1);
        user.setPhone("093939");
        user.setUsername(FirstName);
        user.setAddress(city);
        user.setFavoriteProducts(new ArrayList<>());
        if (!password.equalsIgnoreCase(checkPassword)) {
            resp.sendRedirect("/templates/register");
            return ;
        }
        user.setPassword(password);
       HttpSession session =  req.getSession();
        session.setAttribute("user" ,user);
        resp.sendRedirect(req.getContextPath());
    }
}
