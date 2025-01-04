package controller.admin.management.user;

import dao.DBConnectionPool;
import dao.UserDAO;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {

    private static final String EDIT_PAGE = "templates/admin/admin_edit_user.jsp";
    private static final String MANAGE_USER_CONTROLLER = "ManageUserServlet";
    private DataSource dataSource;


    @Override
    public void init() throws ServletException {
        dataSource = DBConnectionPool.getDataSource();
        if (dataSource == null) {
            throw new ServletException("Failed to initialize DataSource.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = dataSource.getConnection()) {
            String uid = request.getParameter("uid");

            // Fetch the user by ID
            UserDAO dao = new UserDAO(conn);
            User user = dao.getUserById(Integer.parseInt( uid));

            // Set user to request scope
            request.setAttribute("user", user);
        } catch (Exception ex) {
            log("EditUserServlet Error: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(EDIT_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = dataSource.getConnection()) {
            // Gather user edits from request
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

            // Populate User object with updated information
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setFullName(fullName);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);
            user.setGender(gender);

            // Update the user
            UserDAO dao = new UserDAO(conn);
            boolean result = dao.updateUser(user);

            if (result) {
                request.setAttribute("mess", "User updated successfully!");
            } else {
                request.setAttribute("mess", "Error: Unable to update user.");
            }
        } catch (Exception ex) {
            log("EditUserServlet Error: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(MANAGE_USER_CONTROLLER).forward(request, response);
        }
    }
}