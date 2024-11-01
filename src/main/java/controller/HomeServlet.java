package controller;


import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.util.List;
//Chức năng: Hiển thị trang chính của cửa hàng (home.jsp) với danh sách sản phẩm nổi bật.
////Xử lý: Lấy danh sách sản phẩm từ ProductDAO, thiết lập thuộc tính cho request và chuyển hướng đến home.jsp.
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tạo đối tượng DAO
        ProductDAO productDAO = new ProductDAO();

        // Lấy danh sách sản phẩm
        List<Product> productList = productDAO.getAllProducts();

        // Đưa danh sách sản phẩm vào request attribute
        request.setAttribute("productList", productList);

        // Chuyển hướng đến trang home.jsp
        request.getRequestDispatcher("/templates/home.jsp").forward(request, response);
    }
}
