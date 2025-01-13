package controller.web;

import Util.GeneratePassword;
import Util.validation;
import dao.DBConnectionPool;
import dao.ProductDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Product;
import model.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "EditServlet", urlPatterns = {"/secure/EditServlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB threshold for in-memory storage
        maxFileSize = 1024 * 1024 * 10,      // 10MB maximum file size
        maxRequestSize = 1024 * 1024 * 50    // 50MB maximum request size
)

public class EditProfile extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        try {
            con = DBConnectionPool.getDataSource().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("FirstName");
        String lastName = req.getParameter("LastName");
        String email = req.getParameter("Email");
        String phone = req.getParameter("Phone");
        boolean gender = ((int) Integer.parseInt(req.getParameter("gender")) == 1);
        String country = req.getParameter("Country");
        String city = req.getParameter("City");
        String password = req.getParameter("password");
        String checkpassword = req.getParameter("Checkpassword");
        if (!validation.checkPassword(password,checkpassword)){
            req.setAttribute("message","Password is not same Confirm");
            req.getRequestDispatcher("/secure/EditServlet").forward(req, resp);
        }
        // Handle file upload
        Part filePart = req.getPart("avatar"); // Match "name" in input field
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadDir = getServletContext().getRealPath("/")
                + "static" + File.separator + "images" + File.separator + "avatars" + File.separator;

        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdir();
        }
        if (fileName != null && !fileName.isEmpty()) {
            filePart.write(uploadDir  + fileName);
        }
        User user = new User(email, firstName + " " + lastName, city + " " + country
                , phone, "/static/images/avatars/"+ fileName, GeneratePassword.hashPassword(password), id);
        UserDAO userDAO = new UserDAO(con);
        try {
            userDAO.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    resp.sendRedirect(req.getContextPath()+"/templates/LoginServlet.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role.equals("Admin")) {
            request.setAttribute("message", "Please LoginServlet user account !");
            request.getRequestDispatcher("/templates/LoginServlet.jsp").forward(request, response);
        }
        try {
            UserDAO udao = new UserDAO(con);

            User user = udao.getUserById(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("user", user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/templates/User/edit.jsp").forward(request, response);
    }
}
