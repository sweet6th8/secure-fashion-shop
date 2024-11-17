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

//Tìm kiếm theo tên product
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");// tìm tên tiếng việt
        String txtSearch = req.getParameter("txt");
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.searchProductByName(txtSearch);


        req.setAttribute("productList", products);
        req.getRequestDispatcher("/templates/category.jsp").forward(req, resp);

    }
}
