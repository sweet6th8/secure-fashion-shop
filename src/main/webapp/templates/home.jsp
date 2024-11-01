<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<!-- Nội dung của home.jsp -->
<section class="section-intro padding-y-sm">
    <div class="container">
        <div class="intro-banner-wrap">
            <img src="${pageContext.request.contextPath}/static/images/banners/1.jpg" class="img-fluid rounded" alt="Intro Banner">
        </div>
    </div>
</section>

<section class="section-name padding-y-sm">
    <div class="container">
        <header class="section-heading">
            <a href="${pageContext.request.contextPath}/category?id=all" class="btn btn-outline-primary float-right">See all</a>
            <h3 class="section-title">Popular products</h3>
        </header>

        <div class="row">
            <%
                // Lấy danh sách sản phẩm từ request
                List<Product> productList = (List<Product>) request.getAttribute("productList");

                // Kiểm tra xem danh sách sản phẩm có null hay không
                if (productList != null && !productList.isEmpty()) {
                    for (Product product : productList) {
            %>
                    <div class="col-md-3">
                        <div class="card card-product-grid">
                            <div class="img-wrap">
                              <a href="./product?id=<%= product.getId() %>" ><img src="<%= product.getPhoto() %>" alt="<%= product.getName() %>"></a>
                            </div>


                            <figcaption class="info-wrap">
                                <a href="./product?id=<%= product.getId() %>" class="title"><%= product.getName() %></a>
                                <div class="price mt-1">$<%= product.getPrice() %></div>
                            </figcaption>
                        </div>
                    </div>
            <%
                    } // Kết thúc vòng lặp
                } else {
            %>
                <div class="col-md-12">
                    <p>No products available.</p>
                </div>
            <%
                } // Kết thúc kiểm tra
            %>
        </div>
    </div>
</section>
